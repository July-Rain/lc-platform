package lc.platform.admin.modules.sys.service.impl;

import lc.platform.admin.common.utils.PageUtils;
import lc.platform.admin.common.utils.Query;
import lc.platform.admin.common.utils.UtilValidate;
import lc.platform.admin.modules.sys.dao.SysStudentDao;
import lc.platform.admin.modules.sys.entity.SysStudentEntity;
import lc.platform.admin.modules.sys.service.SysStudentService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;



@Service("sysStudentService")
public class SysStudentServiceImpl extends ServiceImpl<SysStudentDao, SysStudentEntity> implements SysStudentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        EntityWrapper ew =new EntityWrapper<SysStudentEntity>();
        if(UtilValidate.isNotEmpty(params.get("neadAss"))){
            ew.isNull("stu_room_code");
        }else{
            ew.isNotNull("stu_room_code");
        }
        Page<SysStudentEntity> page = this.selectPage(
                new Query<SysStudentEntity>(params).getPage(),
                ew
        );

        return new PageUtils(page);
    }

}
