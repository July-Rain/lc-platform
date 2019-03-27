package lc.platform.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import lc.platform.admin.common.utils.PageUtils;
import lc.platform.admin.modules.sys.entity.SysRecordEntity;

import java.util.Map;

/**
 * 角色
 *
 * @author sinorock.net
 * @email ${email}
 * @date 2019-03-23 14:50:54
 */
public interface SysRecordService extends IService<SysRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

