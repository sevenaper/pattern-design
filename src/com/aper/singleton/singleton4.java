package com.aper.singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但是却带来了线程不安全的问题
 * 虽然可以通过synchronized解决，但是也带来了效率下降
 */
public class singleton4 {
    private static singleton4 INSTANCE;

    private singleton4() {
    }

    public static synchronized singleton4 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new singleton4();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(singleton4.getInstance().hashCode())).start();
        }
    }
}
