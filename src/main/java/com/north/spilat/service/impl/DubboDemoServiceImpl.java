package com.north.spilat.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.north.spilat.service.DubboDemoService;
import org.springframework.stereotype.Repository;

/**
 * @author 002353
 */
@Service
@Repository("dubboDemoService")
public class DubboDemoServiceImpl implements DubboDemoService {
    @Override
    public String test(String params) {
        return System.currentTimeMillis() + "-" + params ;
    }
}
