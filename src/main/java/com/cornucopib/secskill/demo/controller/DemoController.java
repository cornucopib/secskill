package com.cornucopib.secskill.demo.controller;

import com.cornucopib.secskill.common.api.controller.BaseController;
import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.demo.entity.DemoEntity;
import com.cornucopib.secskill.demo.service.IDemoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * controller demo.
 *
 * @author cornucopib
 * @since 2023/4/2
 */
@RestController
public class DemoController extends BaseController {
    @Resource
    private IDemoService demoService;

    @GetMapping("/sayHello")
    public List<DemoEntity> sayHello() throws ApiException {
        return demoService.getAll();
    }

}
