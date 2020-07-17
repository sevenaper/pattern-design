package com.aper.Singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但是却带来了线程不安全的问题
 * 虽然可以通过synchronized解决，但是也带来了效率下降
 */
public class singleton5 {
    private static volatile singleton5 INSTANCE;

    private singleton5() {
    }

    public static singleton5 getInstance() {
        if (INSTANCE == null) {
            synchronized (singleton5.class) {
                //妄图通过减小同步代码块的方式提高效率，然后不可行
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new singleton5();
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(singleton5.getInstance().hashCode())).start();
        }
    }
}
