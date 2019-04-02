$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysrecord/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true,hidden:true },
			{ label: '人名', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '晚归时间', name: 'recordTime', index: 'record_time', width: 80 }, 			
			{ label: '晚归原因', name: 'reason', index: 'reason', width: 80 }, 			
			{ label: '联系电话', name: 'phone', index: 'phone', width: 80 }, 			
			{ label: '宿舍号', name: 'roomCode', index: 'room_code', width: 80 }, 			
			{ label: '教师联系电话', name: 'teachePone', index: 'teache_pone', width: 80 }, 			
			{ label: '记录人', name: 'recordName', index: 'record_name', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
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

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		sysRecord: {},
        q:{
            userName: "",
			roomCode:""
        },
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysRecord = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.sysRecord.id == null ? "sys/sysrecord/save" : "sys/sysrecord/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysRecord),
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
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/sysrecord/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
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
		getInfo: function(id){
			$.get(baseURL + "sys/sysrecord/info/"+id, function(result){
                vm.sysRecord = result.sysRecord;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'userName': vm.q.userName,'roomCode': vm.q.roomCode},
                page:page
            }).trigger("reloadGrid");
		}
	}
});