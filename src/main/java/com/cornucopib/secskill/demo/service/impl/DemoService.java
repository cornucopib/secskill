package com.cornucopib.secskill.demo.service.impl;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.common.api.status.impl.ApiStatus;
import com.cornucopib.secskill.demo.dao.DemoDao;
import com.cornucopib.secskill.demo.entity.DemoEntity;
import com.cornucopib.secskill.demo.service.IDemoService;
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
    private DemoDao demoDao;

    @Override
    public List<DemoEntity> getAll() {
        return demoDao.getAll();
    }
}
