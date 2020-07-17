package com.aper.Singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例一个单例,JVM保证线程安全
 * 简单实用，推荐使用
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * (话说你不用的，你装载它干啥）
 */
public class singleton1 {
    private static final singleton1 INSTANCE = new singleton1();

    private singleton1() {
    }

    public static singleton1 getInstance() {
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        singleton1 m1 = singleton1.getInstance();
        singleton1 m2 = singleton1.getInstance();
        System.out.println(m1 == m2);
    }
}
