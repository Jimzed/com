package com.qushihan.正则表达式;

import org.junit.Test;

public class Regex {
    @Test
    public void go(){
        System.out.println("8.".matches("^\\d*\\.([0-9]{3})?$"));
    }
}
