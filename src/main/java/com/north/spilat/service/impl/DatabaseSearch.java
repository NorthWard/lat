package com.north.spilat.service.impl;

import com.north.spilat.service.Search;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * @author laihaohua
 */
@Slf4j
public class DatabaseSearch implements Search {

    @Override
    public List<String> search(String keyword) {
        log.info("now use database search. keyword:" + keyword);
        return null;
    }

}