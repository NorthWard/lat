package com.north.spilat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author laihaohua
 */
@RestController
public class HelloWorldController {
    Random random = new Random();
	
    @RequestMapping("/hello")
    public String index(Integer i) {
        int ii;
        try {
             ii = random.nextInt(2);
            Thread.sleep(ii * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return  e.getLocalizedMessage();
        }
        return ii + "Hello World, " + i;
    }
}