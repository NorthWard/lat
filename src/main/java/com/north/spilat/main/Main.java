package com.north.spilat.main;

import com.north.spilat.service.Search;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> searchList = s.iterator();
        while (searchList.hasNext()) {
            Search curSearch = searchList.next();
            curSearch.search("test");
        }
    }
}
