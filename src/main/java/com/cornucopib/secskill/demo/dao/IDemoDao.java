package com.cornucopib.secskill.demo.dao;

import com.cornucopib.secskill.demo.entity.DemoEntity;

import java.util.List;

/**
 * Dao demo.
 *
 * @author cornucopib
 * @since 2023/4/2
 */
public interface IDemoDao {
    List<DemoEntity> getAll();
}
