package com.cornucopib.secskill.demo.controller;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.demo.entity.DemoEntity;
import com.cornucopib.secskill.demo.service.IDemoService;
import com.cornucopib.secskill.demo.vo.DemoVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/sayGet")
    public List<DemoEntity> sayGet() throws ApiException {
        return demoService.sayGet();
    }

    @PostMapping("/sayPost")
    public List<DemoEntity> sayPost(@Validated @RequestBody DemoVO demoVO) throws ApiException {
        return demoService.sayPost(demoVO);
    }

}
