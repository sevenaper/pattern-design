package com.aper.singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 * 完美方式之一
 */
public class singleton7 {
    private singleton7() {
    }

    private static class singleton7Holder {
        private final static singleton7 INSTANCE = new singleton7();
    }

    public static singleton7 getInstance() {
        return singleton7Holder.INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(singleton7.getInstance().hashCode())).start();
        }
    }
}
