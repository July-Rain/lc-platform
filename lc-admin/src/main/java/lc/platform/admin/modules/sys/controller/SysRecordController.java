package lc.platform.admin.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.toolkit.IdWorker;
import lc.platform.admin.common.utils.PageUtils;
import lc.platform.admin.common.utils.Result;
import lc.platform.admin.modules.sys.entity.SysRecordEntity;
import lc.platform.admin.modules.sys.service.SysRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 角色
 *
 * @author sinorock.net
 * @email ${email}
 * @date 2019-03-23 14:50:54
 */
@RestController
@RequestMapping("sys/sysrecord")
public class SysRecordController extends AbstractController{

    @Autowired
    private SysRecordService sysRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){

        PageUtils page = sysRecordService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){

        SysRecordEntity sysRecord = sysRecordService.selectById(id);

        return Result.ok().put("sysRecord", sysRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(@RequestBody SysRecordEntity sysRecord){

        //you should set the SysRecordEntity's 'id' value
        sysRecord.setId(IdWorker.getIdStr());
		sysRecordService.insert(sysRecord);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SysRecordEntity sysRecord){

        sysRecordService.updateById(sysRecord);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody String[] ids){

		sysRecordService.deleteBatchIds(Arrays.asList(ids));

        return Result.ok();
    }

}
