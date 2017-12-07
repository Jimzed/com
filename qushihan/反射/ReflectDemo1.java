package com.qushihan.反射;

import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo1 {
    @Test(timeout = 100)
    public void reflectConstructor() {// 用反射调用默认构造器
        try {
            String s = "com.qushihan.反射.People";
            Class c = Class.forName(s); //使用 Class的静态 forName() 方法实现动态加载类
            People p = (People) c.newInstance();// 实例化
            p.setName("MIKE");
            System.out.println(p.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 100)
    public void reflectConstructor1() {// 用反射调用非默认构造器
        try {
            String s = "com.qushihan.反射.People";
            Class c = Class.forName(s); //使用 Class的静态 forName() 方法实现动态加载类
            Constructor c1 = c.getConstructor(int.class, String.class);// 实例化
            People p = (People) c1.newInstance(100, "ROSE");
            System.out.println(p.getAge());
            System.out.println(p.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reflectMethod() {// 用反射调用方法
        try {
            String s = "com.qushihan.反射.People";
            Class c = Class.forName(s);//使用 Class的静态 forName() 方法实现动态加载类
            People p = (People) c.newInstance();
            Method m = c.getMethod("setName", String.class);
            m.invoke(p, "TANK");
            Method m1 = c.getMethod("getName");
            System.out.println(m1.invoke(p));
//            Method[] ms=c.getMethods();// 得到类中所有方法
//            for(Method m: ms){
//                System.out.println(m.getName());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reflectField() {// 用反射调用字段
        try {
            String s = "com.qushihan.反射.People";
            Class c = Class.forName(s);// 使用 Class的静态 forName() 方法实现动态加载类
            People p = (People) c.newInstance();
//            Field[] fs=c.getFields();// 返回不是私有的字段
//            Field[] fs=c.getDeclaredFields();// 返回声明的字段
//            for(Field f:fs){
//                System.out.println(f.getName());
//            }
            Field name = c.getDeclaredField("name");
            name.setAccessible(true);// 改变权限
            name.set(p, "JACK");
            System.out.println(name.get(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 100)
    public void reflectArray() {// 用反射调用数组
        try {
            Object o = Array.newInstance(String.class, 10);
            Array.set(o, 0, "Rose");
            Array.set(o, 1, "Jack");
            Array.set(o, 2, "Alice");
            for (int i = 0; i < Array.getLength(o); i++) {
                System.out.println(Array.get(o, i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

