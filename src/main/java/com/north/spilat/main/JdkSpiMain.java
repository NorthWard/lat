package com.north.spilat.main;

import com.north.spilat.service.Search;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author laihaohua
 */
@Slf4j
public class JdkSpiMain {

    public static void main(String[] args) {
        log.info("Hello World!");
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> searchList = s.iterator();
        while (searchList.hasNext()){
            Search search = searchList.next();
            search.search("test");
        }
    }
}
