package com.aper.FlyWeight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Bullet {
    public UUID id = UUID.randomUUID();
    boolean living = true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                ", living=" + living +
                '}';
    }
}

class BulletPool {
    List<Bullet> bullets = new ArrayList<>();

    {
        for (int i = 0; i < 5; i++) {
            bullets.add(new Bullet());
        }
    }

    public Bullet getBullet() {
        for (Bullet b : bullets) {
            if (!b.living) {
                return b;
            }
        }
        return new Bullet();
    }
}

public class Main {
    public static void main(String[] args) {
        BulletPool bulletPool = new BulletPool();
        for (int i = 0; i < 10; i++) {
            Bullet bullet = bulletPool.getBullet();
            System.out.println(bullet);
        }
    }
}
