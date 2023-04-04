package com.cornucopib.secskill.demo.controller;

import com.cornucopib.secskill.demo.entity.DemoEntity;
import com.cornucopib.secskill.demo.dao.DemoDao;
import com.cornucopib.secskill.demo.service.IDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * controller demo.
 *
 * @author cornucopib
 * @since 2023/4/2
 */
@RestController
public class DemoController {
    @Resource
    private IDemoService demoService;

    @GetMapping("/sayHello")
    public List<DemoEntity> sayHello(){
       return demoService.getAll();
    }
}
