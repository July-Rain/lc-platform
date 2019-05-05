$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysstudent/list?neadAss=1',
        datatype: "json",
        colModel: [			
			{ label: 'stuId', name: 'stuId', index: 'stu_id', width: 50, key: true,hidden:true },
			{ label: '学生姓名', name: 'stuName', index: 'stu_name', width: 80 }, 			
			{ label: '学生学号', name: 'stuCode', index: 'stu_code', width: 80 }, 			
			{ label: '学生性别', name: 'stuSex', index: 'stu_sex', width: 50, formatter: function(value, options, row){
                    return value === 0 ?
                        '<span class="label label-danger">男</span>' :
                        '<span class="label label-success">女</span>';
                }},
			{ label: '学生手机号', name: 'stuPhone', index: 'stu_phone', width: 80 }, 			
			{ label: '教师名称', name: 'stuTeacher', index: 'stu_teacher', width: 80 },
			{ label: '教师手机号', name: 'teacherPhone', index: 'teacher_phone', width: 80 }, 			
			{ label: '专业', name: 'stuMajor', index: 'stu_major', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80,
                formatter: function (cellvalue, options, rowObject) {
                    var date = new Date(cellvalue);
                    var seperator1 = "-";
                    var seperator2 = ":";
                    var month = date.getMonth() + 1;

                    var strDate = date.getDate();
                    if (month >= 1 && month <= 9) {
                        month = "0" + month;
                    }
                    if (strDate >= 0 && strDate <= 9) {
                        strDate = "0" + strDate;
                    }

                    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
                    return currentdate;
                }},
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "deptId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        },
    },
    callback: {
        // beforeClick: zTreeBeforeClick
    }
};
var ztree;
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		sysStudent: {
            stuId:"",
            stuName:"",
            stuCode:"",
            stuSex:"0",
            stuPhone:"",
            stuRoomCode:"",
            stuRoomName:"",
            stuTeacher:"",
            teacherPhone:"",
            stuMajor:""
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysStudent =  {
                stuId:"",
                stuName:"",
                stuCode:"",
                stuSex:"0",
                stuPhone:"",
                stuRoomCode:"",
                stuRoomName:"",
                stuTeacher:"",
                teacherPhone:"",
                stuMajor:""
            };
            vm.getDept();
		},
		update: function (event) {
			var stuId = getSelectedRow();
			if(stuId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(stuId);
            vm.getDept();
		},
		saveOrUpdate: function (event) {
			var url = vm.sysStudent.stuId? "sys/sysstudent/update":"sys/sysstudent/save";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysStudent),
			    success: function(result){
			    	if(result.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(result.msg);
					}
				}
			});
		},
		del: function (event) {
			var stuIds = getSelectedRows();
			if(stuIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/sysstudent/delete",
                    contentType: "application/json",
				    data: JSON.stringify(stuIds),
				    success: function(result){
						if(result.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(result.msg);
						}
					}
				});
			});
		},
		getInfo: function(stuId){
			$.get(baseURL + "sys/sysstudent/info/"+stuId, function(result){
                vm.sysStudent = result.sysStudent;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        getDept: function(){
            //加载部门树
            $.get(baseURL + "sys/dept/list", function(r){
                ztree = $.fn.zTree.init($("#deptTree"), setting, r);
                var node = ztree.getNodeByParam("deptCode", vm.sysStudent.stuRoomCode);
                if(node != null && node.virtualFlag == 0){//虚拟的节点 不选中
                    ztree.selectNode(node);
                    vm.sysStudent.stuRoomName  = node.name;
                }
            })
        },
        deptTree: function(){
            var stuIds = getSelectedRows();
            if(stuIds == null){
                return ;
            }


            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择宿舍",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#deptLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级部门
                    var stuRoomCode = node[0].deptCode;
                    var stuRoomName = node[0].name;
                    confirm('确定要分配到该宿舍吗？', function(){
                        $.ajax({
                            type: "POST",
                            url: baseURL + "sys/sysstudent/updateRomm",
                            contentType: "application/json",
                            data: {'stuIds':JSON.stringify(stuIds),'roomCode':stuRoomCode,'roomName':stuRoomName},
                            success: function(result){
                                if(result.code == 0){
                                    alert('操作成功', function(index){
                                        $("#jqGrid").trigger("reloadGrid");
                                    });
                                }else{
                                    alert(result.msg);
                                }
                            }
                        });
                    });
                    layer.close(index);
                }
            });
        },
	}
});