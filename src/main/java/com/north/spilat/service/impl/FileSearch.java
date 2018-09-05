package com.north.spilat.service.impl;

import com.north.spilat.service.Search;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * @author laihaohua
 */
@Slf4j
public class FileSearch implements Search {

    @Override
    public List<String> search(String keyword) {
        log.info("now use file system search. keyword:" + keyword);
        return null;
    }

}