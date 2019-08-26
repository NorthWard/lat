package com.north.spilat.controller;

import com.north.lat.service.SaveTheWorldService;
import com.north.lat.service.impl.CommonSaveTheWorldServiceImpl;
import com.north.lat.service.impl.HeroSaveTheWorldImpl;
import com.north.spilat.service.DubboDemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author laihaohua
 */
@RestController
public class HelloWorldController {
/*    @Resource
    private CommonSaveTheWorldServiceImpl commonSaveTheWorldService;
    @Resource
    private HeroSaveTheWorldImpl heroSaveTheWorld;*/
    @Resource
    private DubboDemoService dubboDemoService;

    private static final String HERO = "laihaohua";

    @RequestMapping("/saveTheWorld")
    public String index(String name) {
/*        SaveTheWorldService saveTheWorldService;
        if(HERO.equals(name)){
            saveTheWorldService = heroSaveTheWorld;
        }else {
            saveTheWorldService = commonSaveTheWorldService;
        }*/
        dubboDemoService.test(name);
        return  null;
    }
}