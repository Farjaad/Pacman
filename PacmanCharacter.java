/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gwss.ics4u.farjaad.unit2culminatingtask;

import hsa.Console;

/**
 */
public abstract class PacmanCharacter implements Movement {

    // CLASS VARIABLES
    protected static Console c;

    protected final static int DIRECTION_DOWN = 1;
    protected final static int DIRECTION_UP = 2;
    protected final static int DIRECTION_RIGHT = 3;
    protected final static int DIRECTION_LEFT = 4;

    protected static int STEP_SIZE = 10;

    // OBJECT VARIABLES
    protected int direction;
    protected boolean alive;
    protected int xLoc;
    protected int yLoc;

    public PacmanCharacter() {
        if (c == null) {
            System.out.println("WARN: HSA Console NOT set.");
        }
    }

    public PacmanCharacter(Console hsaConsole) {
        this();
        if (c == null) {
            c = hsaConsole;
            System.out.println("INFO: HSA Console set.");
        }
    }

    public PacmanCharacter(boolean alive, int xLoc, int yLoc, int direction) {
        this.alive = alive;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.direction = direction;
    }

    public boolean isIsAlive() {
        return alive;
    }

    public void setIsAlive(boolean isAlive) {
        this.alive = isAlive;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        if (xLoc > 0 && xLoc < c.getWidth() - 50) {
            this.xLoc = xLoc;
        } else {
            this.xLoc = (int) (Math.random() * (c.getWidth() - 50));
        }
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        if (yLoc > 5 && yLoc < c.getHeight() - 50) {
            this.yLoc = yLoc;
        } else {
            this.yLoc = (int) (Math.random() * (c.getHeight() - 50));
        }
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void moveLeft() {
        this.erase();
        if (this.xLoc > 10) {
            this.xLoc -= STEP_SIZE;
        }
        this.draw();
    }

    public void moveRight() {
        this.erase();
        if (this.xLoc < c.getWidth() - 55) {
            this.xLoc += STEP_SIZE;
        }
        this.draw();
    }

    public void moveUp() {
        this.erase();
        if (this.yLoc > 10) {
            this.yLoc -= STEP_SIZE;
        }
        this.draw();
    }

    public void moveDown() {
        this.erase();
        if (this.yLoc < c.getHeight() - 50) {
            this.yLoc += STEP_SIZE;
        }
        this.draw();
    }

    public void move() {

        switch (this.direction) {
            case 1:
                moveDown();
                break;
            case 2:
                moveUp();
                break;
            case 3:
                moveRight();
                break;
            case 4:
                moveLeft();
                break;

        }
    }

  
    public abstract void draw();

    public abstract void erase();

    public abstract void kill();

    /**
     * The parent class, PacmanCharacter, must have reference to the HSA
     * Console. Set it ONCE.
     *
     * @param hsaConsole
     */
    public static void setConsole(Console hsaConsole) {
        c = hsaConsole;
    }

}

