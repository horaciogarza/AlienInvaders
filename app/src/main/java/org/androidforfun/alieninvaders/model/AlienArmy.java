package org.androidforfun.alieninvaders.model;

import org.androidforfun.alieninvaders.framework.Actor;

import java.util.List;

public class AlienArmy extends Actor {
    private float speedX, speedY;
    private List<Alien> aliens;
    private String direction;

    public AlienArmy(List<Alien> aliens) {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.speedX = 1;
        this.speedY = 2;
        this.aliens=aliens;
        this.direction = "right";
        update();
    }

    //public boolean hasAlien() {
    //    return (aliens.size() > 0);
    //}

    public void move() {
        if (direction.equals("left")) {
            moveLeft();
        } else {
        //if (direction.equals("right")) {
            moveRight();
        }
    }

    private void moveLeft() {
        update();
        if (x > AlienInvadersWorld.CELL_WIDTH) {
            for (Alien alien: aliens) {
                alien.moveLeft();
            }
        } else {
            changeDirection();
        }
    }

    private void moveRight() {
        update();
        if ((x + width) < (AlienInvadersWorld.WORLD_WIDTH - AlienInvadersWorld.CELL_WIDTH)) {
            for (Alien alien: aliens) {
                alien.moveRight();
            }
        } else {
            changeDirection();
        }
    }

    private void changeDirection() {
        //y += speedY;
        direction = (direction.equals("left")) ? "right" : "left";
        for (Alien alien: aliens) {
            alien.moveForward();
        }
    }

    public void update() {
        int xmax=Integer.MIN_VALUE, ymax=Integer.MIN_VALUE;

        this.x=Integer.MAX_VALUE;
        this.y=Integer.MAX_VALUE;

        if (aliens.size()!=0) {
            for (Alien alien: aliens) {
                if (alien.getX()<x)
                    this.x=alien.getX();
                if (alien.getY()<y)
                    this.y=alien.getY();
                if ((alien.getX()+alien.getWidth())>xmax)
                    xmax=alien.getX()+alien.getWidth();
                if ((alien.getY()+alien.getHeight())>ymax)
                    ymax=alien.getY()+alien.getHeight();
            }
            this.width=xmax-this.x;
            this.height=ymax-this.y;
        } else {
            this.x=0;
            this.y=0;
            this.width=0;
            this.height=0;
        }
    }

    public boolean isOnEarth() {
        //if (this.y==Integer.MAX_VALUE) {
        //    return false;
        //}
        return (this.y+this.height)>(AlienInvadersWorld.EARTH_LEVEL*AlienInvadersWorld.CELL_HEIGHT);
    }

    public void increaseSpeed() {
        for (Alien alien: aliens) {
            alien.increaseSpeed();
        }
        //speedX+=(0.01*AlienInvadersWorld.getInstance().getLevel());
    }
}
