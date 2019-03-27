package lc.platform.admin.modules.sys.service.impl;

import lc.platform.admin.common.utils.PageUtils;
import lc.platform.admin.common.utils.Query;
import lc.platform.admin.modules.sys.dao.SysRecordDao;
import lc.platform.admin.modules.sys.entity.SysRecordEntity;
import lc.platform.admin.modules.sys.service.SysRecordService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("sysRecordService")
public class SysRecordServiceImpl extends ServiceImpl<SysRecordDao, SysRecordEntity> implements SysRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysRecordEntity> page = this.selectPage(
                new Query<SysRecordEntity>(params).getPage(),
                new EntityWrapper<SysRecordEntity>()
        );

        return new PageUtils(page);
    }

}
