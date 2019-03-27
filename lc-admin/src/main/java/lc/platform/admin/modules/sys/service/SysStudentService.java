package lc.platform.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import lc.platform.admin.common.utils.PageUtils;
import lc.platform.admin.modules.sys.entity.SysStudentEntity;

import java.util.Map;

/**
 * 系统用户
 *
 * @author sinorock.net
 * @email ${email}
 * @date 2019-03-23 15:10:27
 */
public interface SysStudentService extends IService<SysStudentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

