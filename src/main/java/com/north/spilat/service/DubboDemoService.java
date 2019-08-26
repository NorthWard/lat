package com.north.spilat.service;


import com.north.spilat.threadpool.Dto;

import java.util.Map;

/**
 * @author laihaohua
 */
public interface DubboDemoService {
    String test(String params);
    Map<Object, Object>  test2(Dto p1, String p2);
}
