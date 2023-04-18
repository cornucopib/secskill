package com.cornucopib.secskill.demo.service;

import com.cornucopib.secskill.demo.entity.DemoEntity;
import com.cornucopib.secskill.demo.vo.DemoVO;

import java.util.List;

/**
 * @author cornucopib
 * @since 2023/4/3
 */
public interface IDemoService {

    /**
     * 执行get逻辑
     *
     * @return 列表
     */
    List<DemoEntity> sayGet();


    /**
     * 执行post逻辑
     *
     * @return 列表
     */
    List<DemoEntity> sayPost(DemoVO demoVO);

}
