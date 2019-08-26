package com.north.spilat.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.north.spilat.service.DubboDemoService;
import com.north.spilat.threadpool.Dto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public Map<Object, Object> test2(Dto p1, String p2) {
        Map<Object, Object> map = new HashMap<>(2);
        map.put(p1, p1);
        map.put(p2, p2);
        return map;
    }
}
