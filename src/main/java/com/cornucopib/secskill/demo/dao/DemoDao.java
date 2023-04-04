package com.cornucopib.secskill.demo.dao;

import com.cornucopib.secskill.demo.entity.DemoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Dao demo.
 *
 * @author cornucopib
 * @since 2023/4/2
 */
@Mapper
public interface DemoDao {
    List<DemoEntity> getAll();
}
