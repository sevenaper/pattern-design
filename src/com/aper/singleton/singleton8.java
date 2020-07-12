package com.aper.singleton;

/**
 * 不仅可以解决线程同步，还可以防止反序列化(没有构造方法，防止产生多个单例)
 */
public enum singleton8 {
    INSTANCE;

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(singleton8.INSTANCE.hashCode())).start();
        }
    }
}
