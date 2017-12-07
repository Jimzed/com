package com.qushihan.集合;

import org.junit.Test;

import java.util.*;

public class 集合数组元素比较Comparator {
    @Test
    public void test() {
        Map<Integer, String> map = new HashMap<Integer, String>() {{
            put(2, "B");
            put(4, "D");
            put(1, "A");
            put(3, "C");
        }};
        List<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(map.entrySet());
        for (Map.Entry<Integer, String> a : list) {
            System.out.println(a);
        }
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return -(o1.getKey() - o2.getKey());
            }
        });
        for (Map.Entry<Integer, String> a : list) {
            System.out.println(a);
        }
    }
}
