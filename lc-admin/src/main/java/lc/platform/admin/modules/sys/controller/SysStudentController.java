package lc.platform.admin.modules.sys.controller;

import java.util.*;

import com.baomidou.mybatisplus.toolkit.IdWorker;
import lc.platform.admin.common.utils.PageUtils;
import lc.platform.admin.common.utils.Result;
import lc.platform.admin.modules.sys.entity.SysStudentEntity;
import lc.platform.admin.modules.sys.service.SysStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 系统用户
 *
 * @author sinorock.net
 * @email ${email}
 * @date 2019-03-23 15:10:27
 */
@RestController
@RequestMapping("sys/sysstudent")
public class SysStudentController extends AbstractController{

    @Autowired
    private SysStudentService sysStudentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){

        PageUtils page = sysStudentService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{stuId}")
    public Result info(@PathVariable("stuId") String stuId){

        SysStudentEntity sysStudent = sysStudentService.selectById(stuId);

        return Result.ok().put("sysStudent", sysStudent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody SysStudentEntity sysStudent){

        sysStudent.setStuId(IdWorker.getIdStr());
        sysStudent.setCreateTime(new Date());
        //you should set the SysStudentEntity's 'id' value
		sysStudentService.insert(sysStudent);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SysStudentEntity sysStudent){

        sysStudentService.updateById(sysStudent);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody String[] stuIds){

		sysStudentService.deleteBatchIds(Arrays.asList(stuIds));

        return Result.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/updateRoom")
    public Result updateRoom(String stuIds,String roomCode,String roomName){

        List<SysStudentEntity> stuList = new ArrayList<>();
        String [] arr=stuIds.split(",");
        for(String id:arr){
            SysStudentEntity stu = new SysStudentEntity();
            stu.setStuId(id);
            stu.setStuRoomCode(roomCode);
            stu.setStuRoomName(roomName);
            stuList.add(stu);
        }
        sysStudentService.updateBatchById(stuList);

        return Result.ok();
    }

}
