package org.androidforfun.alieninvaders.model;

public class ShipProjectile extends Projectile {
    public ShipProjectile(int x, int y) {
        super(x, y);
    }

    public void move() {
        moveBy(0, -1);
        //y -= 1;
        //distanceTraveled += 1;
        //if (distanceTraveled > maxDistance)
        //    kill();
    }
}
