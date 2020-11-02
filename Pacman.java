/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gwss.ics4u.farjaad.unit2culminatingtask;

import java.awt.Color;

/**
 *
 * @author 1rawasiafar
 */
public class Pacman extends PacmanCharacter {

    protected static final Color YELLOW = java.awt.Color.YELLOW;
    protected static final Color WHITE = java.awt.Color.white;
    protected static final int RADIUS = 50;

    protected boolean poweredUp;
    protected int points;
    protected int numberOfLives;

    public Pacman() {
        super();
    }

    public Pacman(boolean alive, int xLoc, int yLoc, int direction) {
        this();
        //super(alive, xLoc, yLoc, direction);
        this.poweredUp = false;
        this.points = 0;
        this.numberOfLives = 3;
    }

    public Pacman(boolean alive, int xLoc, int yLoc, int direction, boolean poweredUp, int points, int numberOfLives) {
        this(alive, xLoc, yLoc, direction);
//super(alive, xLoc, yLoc, direction);
        this.poweredUp = poweredUp;
        this.points = points;
        this.numberOfLives = numberOfLives;

    }

    public boolean isPoweredUp() {
        return poweredUp;
    }

    public void setPoweredUp(boolean poweredUp) {
        this.poweredUp = poweredUp;
        if (poweredUp == true) {
            System.out.println("Pacman is now powered up");
        } else if (poweredUp == false) {
            System.out.println("Pacman is now not powered up");
        }
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    @Override
    public boolean isIsAlive() {
        if (this.numberOfLives > 0) {
            this.alive = true;
        }
        return super.isIsAlive();
    }

    @Override
    public void setIsAlive(boolean isAlive) {
        super.setIsAlive(isAlive);
    }

    private void addPoints(int points) {
        this.points += points;
    }

    private void losePoints(int points) {
        this.points -= points;
    }

    private void resetPoints() {
        this.points = 0;
    }

    public void powerUpOrDown(boolean poweredUp) {
        this.poweredUp = poweredUp;

    }

    public int getPoints() {
        return points;
    }

    private void setPoints(int points) {
        this.points = points;
    }

    @Override
    public void kill() {
        if (this.numberOfLives > 0 && this.alive == true && this.poweredUp == false) {
            System.out.println("Pacman lost a life!");
            this.numberOfLives--;
        } else if (this.poweredUp == true) {
            System.out.println("Pacman can't lose a life since it's powered up!");
        }

        if (this.numberOfLives == 0) {
            System.out.println("Pacman is dead!");
            this.erase();
            this.alive = false;
        }
    }

    public void respawn(Pacman p) {
        if (p.numberOfLives == 0 && p.isIsAlive() == false) {
            p.numberOfLives = 3;
            p.alive = true;
            p.direction = Pacman.DIRECTION_DOWN;
            p.xLoc = 100;
            p.yLoc = 0;
            p.setIsAlive(true);
            p.draw();
            System.out.println("Pacman is now alive again!");
        } else if (p.isIsAlive() == true) {
            System.out.println("Can't bring pacman back to life if its already alive!");
        }
    }

    @Override
    public void draw() {
        if (this.numberOfLives > 0 && this.isIsAlive() == true) {
            c.setColor(YELLOW);
            c.fillArc(xLoc, yLoc, RADIUS, RADIUS, 30, 300);
        }
    }

    @Override
    public void erase() {
        c.setColor(WHITE);
        c.fillOval(xLoc, yLoc, RADIUS, RADIUS);

    }

    public void superSpeed(Pacman p) {
        if (p.poweredUp == true) {
            PacmanCharacter.STEP_SIZE = 20;
        } else {
            PacmanCharacter.STEP_SIZE = 10;
        }
    }

    @Override
    public String toString() {
        return "---------------------------------"
                + "\n\tPacman: "
                + "\n\tAlive = " + this.alive
                + "\n\tX-Loc= " + this.xLoc
                + "\n\tY-Loc= " + this.yLoc
                + "\n\tDirection=" + this.direction
                + "\n\tNumber of Lives= " + this.numberOfLives
                + "\n\tPowered Up= " + this.poweredUp
                + "\n\tPoints= " + this.points;
    }
}
