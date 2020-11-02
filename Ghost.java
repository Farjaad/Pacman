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
public class Ghost extends PacmanCharacter {

    protected static final Color CYAN = java.awt.Color.CYAN;
    protected static final Color RED = java.awt.Color.RED;
    protected static final Color ORANGE = java.awt.Color.ORANGE;
    protected static final Color MAGENTA = java.awt.Color.magenta;
    protected static final Color EDIBLE = java.awt.Color.green;
    protected static final Color WHITE = java.awt.Color.white;
    protected static final int HEIGHT = 80;
    protected static final int WIDTH = 40;

    protected Color colour;
    protected boolean isEdible;
    protected boolean isAlive;

    public Ghost() {
        super();
    }

    public Ghost(boolean alive, int xLoc, int yLoc, int direction, Color colour) {
        super(alive, xLoc, yLoc, direction);
        this.colour = colour;
    }

    @Override
    public void draw() {
        c.setColor(this.colour);
        c.fillArc(this.xLoc, this.yLoc, WIDTH, HEIGHT, 0, 180);
    }

    @Override
    public void erase() {
        c.setColor(WHITE);
        c.fillArc(xLoc, yLoc, WIDTH, HEIGHT, 0, 180);
    }

    @Override
    public void kill() {
        if (this.alive == false) {
            System.out.println("Ghost is already dead");
        } else {
            System.out.println("Ghost Killed");
            this.erase();
            this.alive = false;
        }
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public boolean isIsEdible() {
        return isEdible;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void makeEdible() {
        if (this.isEdible == true) {
            System.out.println("Ghost is already edible!");
            this.colour = EDIBLE;

        } else if (isEdible == false) {
            //sets to default colour
            this.colour = Color.PINK;
            System.out.println("Ghost is now edible!");
            this.isEdible = true;

        }
    }

    public void makeUnEdible() {
        if (this.isEdible == false) {
            System.out.println("Ghost is already unedible!");
        } else if (this.isEdible == true) {
            this.isEdible = false;
            //sets to default colour
            this.colour = RED;
            this.draw();
            System.out.println("Ghost is now unedible!");

        }
    }

    @Override
    public String toString() {
        return "---------------------------------"
                + "\n\tGhost: "
                + "\n\tAlive = " + this.alive
                + "\n\tX-Loc= " + this.xLoc
                + "\n\tY-Loc= " + this.yLoc
                + "\n\tDirection=" + this.direction
                + "\n\tEdible= " + this.isEdible;

    }

    public void respawn(Ghost g) {
        if (g.isIsAlive() == false) {
            g.alive = true;
            g.direction = Pacman.DIRECTION_DOWN;
            g.xLoc = (int) (Math.random() * (c.getWidth() - 40));
            g.yLoc = (int) (Math.random() * (c.getHeight() - 45));;
            g.setColour(Ghost.CYAN);
            g.setIsAlive(true);
            g.draw();
            System.out.println("Ghost is now alive again!");
        } else if (g.isIsAlive() == true) {
            System.out.println("Can't bring ghost back to life if it's already alive!");
        }
    }
}
