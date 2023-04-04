package com.cornucopib.secskill.demo.service;

import com.cornucopib.secskill.demo.entity.DemoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cornucopib
 * @since 2023/4/3
 */
public interface IDemoService {
    /**
     * 获取所有数据列表
     * @return 列表
     */
    List<DemoEntity> getAll();
}
