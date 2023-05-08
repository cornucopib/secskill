package com.cornucopib.secskill.demo.service.impl;

import com.cornucopib.secskill.common.api.exception.Asserts;
import com.cornucopib.secskill.common.api.status.impl.ApiStatus;
import com.cornucopib.secskill.demo.dao.IDemoDao;
import com.cornucopib.secskill.demo.entity.DemoEntity;
import com.cornucopib.secskill.demo.service.IDemoService;
import com.cornucopib.secskill.demo.vo.DemoVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * DEMO SERVICE.
 *
 * @author cornucopib
 * @since 2023/4/3
 */
@Service
public class DemoService implements IDemoService {
    @Resource
    private IDemoDao IDemoDao;

    @Override
    public List<DemoEntity> sayGet() {
        return IDemoDao.getAll();
    }

    @Override
    public List<DemoEntity> sayPost(DemoVO demoVO) {
        //模拟dao层异常
        if (demoVO.getAge() > 40) {
            Asserts.fail(ApiStatus.UNKNOWN_ERROR);
        }
        return IDemoDao.getAll();
    }
}
