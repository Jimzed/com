package com.qushihan.集合;

import org.junit.Test;
import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo1 {
    @Test
    public void go(){
        List list=new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        Iterator it=list.iterator();

        System.out.println(it.next());
        it.remove();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}


