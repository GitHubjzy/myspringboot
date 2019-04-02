package com.tuling.springbootwar.controller;

import com.tuling.springbootwar.service.TulingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jizy
 * @create 2019/4/2
 * @since 1.0.0
 */
@Controller
@RequestMapping("/tuling")
public class TulingController {

    @Autowired
    private TulingServiceImpl tulingService;
    @RequestMapping("/testImpot")
    @ResponseBody
    public void test(){
         tulingService.getName();
    }
}
