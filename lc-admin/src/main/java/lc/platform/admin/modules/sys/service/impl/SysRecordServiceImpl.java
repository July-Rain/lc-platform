package lc.platform.admin.modules.sys.service.impl;

import lc.platform.admin.common.utils.PageUtils;
import lc.platform.admin.common.utils.Query;
import lc.platform.admin.common.utils.UtilValidate;
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
        EntityWrapper<SysRecordEntity> ew = new EntityWrapper<SysRecordEntity>();
        if(UtilValidate.isNotEmpty(params.get("userName"))){
            ew.like("user_name",params.get("userName").toString());
        }
        if(UtilValidate.isNotEmpty(params.get("roomCode"))){
            ew.like("room_code",params.get("roomCode").toString());
        }
        Page<SysRecordEntity> page = this.selectPage(
                new Query<SysRecordEntity>(params).getPage(),
                ew
        );

        return new PageUtils(page);
    }

}
