package com.qushihan.集合;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo1 {
    @Test
    public void test() {
        Map<Integer, String> map = new HashMap<Integer, String>() {{
            put(1, "A");
            put(2, "B");
            put(3, "C");
            put(4, "D");
        }};
        // 第一种遍历方式
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> e = it.next();
            System.out.print(e.getKey() + ":" + e.getValue());
            System.out.println();
        }
        System.out.println("-------------");
        // 第二种遍历方式
        Set<Integer> set1 = map.keySet();
        Iterator<Integer> it1 = set1.iterator();
        while (it1.hasNext()) {
            int i = it1.next();
            System.out.print(i + ":" + map.get(i));
            System.out.println();
        }
    }
}
