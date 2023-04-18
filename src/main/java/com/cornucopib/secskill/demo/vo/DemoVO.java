package com.cornucopib.secskill.demo.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Demo VO.
 *
 * @author cornucopib
 * @since 2023/4/18
 */
@Data
public class DemoVO {

    @NotEmpty(message = "名称不能为空!")
    private String name;

    @Min(value = 18,message = "最小年龄18")
    private int age;

}
