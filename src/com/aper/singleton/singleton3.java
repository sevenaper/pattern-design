package com.aper.singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但是却带来了线程不安全的问题
 */
public class singleton3 {
    private static singleton3 INSTANCE;

    private singleton3() {
    }

    public static singleton3 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new singleton3();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(singleton3.getInstance().hashCode())).start();
        }
    }
}
