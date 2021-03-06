package com.aper.Singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但是却带来了线程不安全的问题
 * 虽然可以通过synchronized解决，但是也带来了效率下降
 */
public class singleton6 {
    private static singleton6 INSTANCE;

    private singleton6() {
    }

    public static singleton6 getInstance() {
        if (INSTANCE == null) {
            synchronized (singleton5.class) {
                //双重检查
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new singleton6();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(singleton6.getInstance().hashCode())).start();
        }
    }
}
