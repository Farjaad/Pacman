/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gwss.ics4u.farjaad.unit2culminatingtask;

import hsa.Console;

/**
 * @author: Farjaad Rawasia 
 * Date: October 10, 2014 
 * Version : v0.1 
 * Description:
 * A program that tests different attributes and methods of pacman characters
 * (e.g ghosts and pacman) 
 */
public class PacmanTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Console c = new Console();
        PacmanCharacter.setConsole(c);

        Ghost inky = new Ghost(true, 50, 70, PacmanCharacter.DIRECTION_DOWN, Ghost.CYAN);
        Ghost clyde = new Ghost(true, 150, 270, PacmanCharacter.DIRECTION_RIGHT, Ghost.ORANGE);
        Ghost blinky = new Ghost(true, 300, 350, PacmanCharacter.DIRECTION_UP, Ghost.RED);
        Ghost pinky = new Ghost(true, 470, 400, PacmanCharacter.DIRECTION_LEFT, Ghost.MAGENTA);
        Pacman pacman = new Pacman(true, 200, 400, PacmanCharacter.DIRECTION_LEFT);

        //CASE 1: Sets inky's x and y locations to negative numbers
        //Pre-Conditions: Sets inky's x and y locations to negative numbers
        //Post Conditions: Sets inky's x and y locations to random coordinates on the console screen
        // and prints coordinates out onto the screen
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 1: Sets inky's x and y locations to negative numbers and then sets it to random numbers");
        System.out.println("");
        inky.setxLoc(-343545);
        inky.setyLoc(-344);
        System.out.println("X-LOC:" + inky.getxLoc());
        System.out.println("Y-LOC:" + inky.getyLoc());

        //CASE 2: Sets inky's x and y locations to x and y locations above the allowed numbers on the screen
        //Pre-Conditions: Sets inky's x and y locations to numbers above the allowed numbers on the screen
        //Post Conditions: Sets inky's x and y locations to random coordinates on the console screen
        // and prints coordinates out onto the screen
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 2: Sets inky's x and y locations to x and y locations above the allowed numbers on the screen");
        System.out.println("");
        inky.setxLoc(343545);
        inky.setyLoc(344556);
        System.out.println("X-LOC:" + inky.getxLoc());
        System.out.println("Y-LOC:" + inky.getyLoc());

        //CASE 3: Sets pacman's x and y locations to negative numbers
        //Pre-Conditions: Sets pacman's x and y locations to negative numbers
        //Post Conditions: Sets pacman's x and y locations to random coordinates on the console screen
        // and prints coordinates out onto the screen
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 3: Sets pacman's x and y locations to negative numbers and then sets it to random numbers");
        System.out.println("");
        pacman.setxLoc(-343545);
        pacman.setyLoc(-3446);
        System.out.println("X-LOC:" + pacman.getxLoc());
        System.out.println("Y-LOC:" + pacman.getyLoc());

        //CASE 4: Sets pacman's x and y locations to x and y locations above the allowed numbers on the screen
        //Pre-Conditions: Sets pacman's x and y locations to numbers above the allowed numbers on the screen
        //Post Conditions: Sets pacman's x and y locations to random coordinates on the console screen
        // and prints coordinates out onto the screen
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 4: Sets pacman's x and y locations to x and y locations above the allowed numbers on the screen");
        System.out.println("");
        inky.setxLoc(343545);
        inky.setyLoc(344556);
        System.out.println("X-LOC:" + pacman.getxLoc());
        System.out.println("Y-LOC:" + pacman.getyLoc());

        //CASE 5: Moves Pacman right and the 4 ghosts up, down, right and left and then kills pacman (tests movement in all directons)
        //Pre-Conditions: sets paacman and 4 ghosts to specific x and y locations
        //Post Conditions: pacman and 4 ghosts end up at end of screen, pacman is killed and it loses one life
        // user is told the lives before and after and that pacman has been killed
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 5: Move pacman and ghosts (tests movement in all directons) and then kills pacman");
        System.out.println("");

        //moves pacman and ghosts, up down, right and left          
        for (int i = 0; i < 100; i++) {
            inky.move();
            clyde.move();
            blinky.move();
            pinky.move();
            pacman.move();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }

        }
        System.out.println("Number of Lives Before: " + pacman.getNumberOfLives());
        pacman.kill();
        System.out.println("Number of Lives After: " + pacman.getNumberOfLives());
        System.out.println("");
        //pauses before moving to next case
        try {
            Thread.sleep(2500);
        } catch (Exception e) {

        }
        //CASE 6: Moves Pacman right and the 4 ghosts in a different direction than before (tests movement in all directons) and kills pacman
        //Pre-Conditions: sets paacman and 4 ghosts to specific x and y locations
        //Post Conditions: pacman and 4 ghosts end up at end of screen, pacman is killed and it loses one life
        // user is told the lives before and after and that pacman has been killed   
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 6: Move pacman and ghosts (tests movement in all directons) and then kills pacman");
        System.out.println("");

        inky.setDirection(Ghost.DIRECTION_RIGHT);
        clyde.setDirection(Ghost.DIRECTION_DOWN);
        blinky.setDirection(Pacman.DIRECTION_LEFT);
        pinky.setDirection(Pacman.DIRECTION_UP);
        pacman.setDirection(Pacman.DIRECTION_RIGHT);
        for (int i = 0; i < 30; i++) {
            inky.move();
            clyde.move();
            blinky.move();
            pinky.move();
            pacman.move();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }

        }
        System.out.println("Number of Lives Before: " + pacman.getNumberOfLives());
        pacman.kill();
        System.out.println("Number of Lives After: " + pacman.getNumberOfLives());
        //pauses before moving to next case
        try {
            Thread.sleep(2500);
        } catch (Exception e) {

        }

        //CASE 7: Moves Pacman right and the 4 ghosts up, down, right and left and powersUp pacman andthen kills pacman
        //Pre-Conditions: sets pacman and 4 ghosts to specific x and y locations
        //Post Conditions: pacman and 4 ghosts end up at end of screen, pacman is not killed since its powered up
        //user is told lives before and after and that pacman can't be killed since it's powered up
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 7:  Move pacman and ghosts and then tries to kill pacman (doesn't die since it is powered up)");
        System.out.println("");
        inky.setDirection(Ghost.DIRECTION_UP);
        clyde.setDirection(Ghost.DIRECTION_LEFT);
        blinky.setDirection(Pacman.DIRECTION_DOWN);
        pinky.setDirection(Pacman.DIRECTION_RIGHT);
        pacman.setDirection(Pacman.DIRECTION_LEFT);

        for (int i = 0; i < 50; i++) {
            inky.move();
            clyde.move();
            blinky.move();
            pinky.move();
            pacman.move();
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }

        pacman.setPoweredUp(true);
        System.out.println("Number of Lives Before: " + pacman.getNumberOfLives());
        pacman.kill();
        System.out.println("Number of Lives After: " + pacman.getNumberOfLives());

        //pauses before moving to next case
        try {
            Thread.sleep(2500);
        } catch (Exception e) {

        }

        //CASE 8: Moves Pacman right and the 4 ghosts up, down, right and left and then kills pacman and erases pacman
        //Pre-Conditions: sets pacman and 4 ghosts to specific x and y locations
        //Post Conditions: pacman and 4 ghosts end up at end of screen, pacman is killed and it loses one life
        // user is told lives before and after and that pacman lost a life and is now dead
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 8: Move pacman and ghosts and then kills pacman and erases him");
        System.out.println("");
        inky.setDirection(Ghost.DIRECTION_LEFT);
        clyde.setDirection(Ghost.DIRECTION_RIGHT);
        blinky.setDirection(Pacman.DIRECTION_UP);
        pinky.setDirection(Pacman.DIRECTION_DOWN);
        pacman.setDirection(Pacman.DIRECTION_RIGHT);
        //moves pacman and ghosts, up down, right and left          
        for (int i = 0; i < 50; i++) {
            inky.move();
            clyde.move();
            blinky.move();
            pinky.move();
            pacman.move();
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }

        }

        pacman.setPoweredUp(false);
        try {
            Thread.sleep(400);
        } catch (Exception e) {

        }
        System.out.println("Number of Lives Before: " + pacman.getNumberOfLives());
        pacman.kill();
        System.out.println("Number of Lives After: " + pacman.getNumberOfLives());
        System.out.println("");

        //pauses before moving to next case
        try {
            Thread.sleep(2500);
        } catch (Exception e) {

        }

        //CASE 9: tries killing pacman again
        //Pre-Conditions: kills pacman twice (once to give it zero lives) the other to test if it loses lives even when # of lives = 0
        //Post Conditions: pacman loses life first time it's killed but pacman doesn't lose a life the second time because it already has 0 lives
        // user is told the lives before and after (the same) and that pacman is dead
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 9: tries killing pacman again even though # of lives = 0");
        System.out.println("");

        System.out.println("Number of Lives Before: " + pacman.getNumberOfLives());
        pacman.kill();
        System.out.println("Number of Lives After: " + pacman.getNumberOfLives());
        System.out.println("");

        //pauses before moving to next case
        try {
            Thread.sleep(2500);
        } catch (Exception e) {

        }
        //CASE 10: Kills inky (cyan ghost)
        //Pre-Conditions: kills inky
        //Post Conditions: inky dies and clyde is erased from console screen
        // user is told that the ghost is killed
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 10: Kills inky (cyan ghost) and erases him");
        System.out.println("");

        inky.kill();

        //pauses before moving to next case
        try {
            Thread.sleep(2500);
        } catch (Exception e) {

        }
        //CASE 11: Kills inky again
        //Pre-Conditions: kills inky
        //Post Conditions: inky doesn't die since it;s already dead
        // user is told that the ghost can't be killed
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 11: Kills inky (cyan ghost) and erases him");
        System.out.println("");

        inky.kill();

        //pauses before moving to next case
        try {
            Thread.sleep(2500);
        } catch (Exception e) {

        }

        //CASE 12: Makes remaining ghosts edible (changes their colour)
        //Pre-Conditions: makes the ghosts edible
        //Post Conditions: changes colour to green and user is told the ghost is
        //now edible
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 12: Makes remaining ghosts edible (changes their colour)");
        System.out.println("");

        clyde.makeEdible();
        blinky.makeEdible();
        pinky.makeEdible();
        clyde.draw();
        blinky.draw();
        pinky.draw();

        //pauses before moving to next case
        try {
            Thread.sleep(2500);
        } catch (Exception e) {

        }
        //CASE 13: Makes clyde edible
        //Pre-Conditions: makes clyde edible
        //Post Conditions: stays the same and user is told the ghost is already edible
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 13: Makes remaining ghosts edible (changes their colour)");
        System.out.println("");
        clyde.makeEdible();

        //CASE 14: Makes one ghost unedible again
        //Pre-Conditions: makes the ghost unedible
        //Post Conditions: changes colour to red (default colour) and tells user that ghost is now unedible
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 14: Makes one ghost unedible again");
        System.out.println("");
        clyde.makeUnEdible();

        //pauses before moving to next case
        try {
            Thread.sleep(2500);
        } catch (Exception e) {

        }
        //CASE 15: Makes one ghost unedible again
        //Pre-Conditions: makes the ghost unedible
        //Post Conditions: d tells user that ghost is already unedible
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 15: Makes one ghost unedible again");
        System.out.println("");
        clyde.makeUnEdible();

        //pauses before moving to next case
        try {
            Thread.sleep(2500);
        } catch (Exception e) {

        }

        //CASE 16: Brings pacman back to life
        //Pre-Conditions: brings pacman back to life
        //Post Conditions: sets lives to 3 and draws pacman to screen again
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 16: Brings pacman back to life");
        System.out.println("");
        System.out.println("Number of Lives Before: " + pacman.getNumberOfLives());
        pacman.respawn(pacman);
        System.out.println("Number of Lives After: " + pacman.getNumberOfLives());

        //pauses before moving to next case
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }

        //CASE 17: Powers pacman up and moves him at superspeed (double the step size) 
        //Pre-Conditions: powers pacman up
        //Post Conditions: moves pacman at superspeed, prints out to user that pacman is now powered up, prints out
        //step size before and after to show step size is bigger since its super speed
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 17: Powers pacman up and moves him at superspeed (double the step size) ");
        System.out.println("Step Size Before: " + PacmanCharacter.STEP_SIZE);
        pacman.setPoweredUp(true);
        pacman.superSpeed(pacman);
        System.out.println("Step Size After: " + PacmanCharacter.STEP_SIZE);
        for (int i = 0; i < 20; i++) {
            pacman.move();
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }

        }
        //pauses before moving to next case
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        //CASE 18: Moves pacman right
        //Pre-Conditions: sets direction of pacman to right
        //Post Conditions: moves pacman right at superspeed, 
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 18: Moves pacman right at superspeed ");
        pacman.setDirection(Pacman.DIRECTION_RIGHT);
        for (int i = 0; i < 20; i++) {
            pacman.move();
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }

        }
        //pauses before moving to next case
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }
        //CASE 19: Moves pacman up
        //Pre-Conditions: sets direction of pacman to up
        //Post Conditions: moves pacman up at superspeed
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 19: Moves pacman up at superspeed");
        pacman.setDirection(Pacman.DIRECTION_UP);
        for (int i = 0; i < 20; i++) {
            pacman.move();
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }

        //pauses before moving to next case
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }

        //CASE 20: Moves pacman left
        //Pre-Conditions: sets direction of pacman to left
        //Post Conditions: moves pacman up at superspeed then sets it normal speed again, prints out step size before and after
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 20: Moves pacman left at superspeed");
        pacman.setDirection(Pacman.DIRECTION_DOWN);
        for (int i = 0; i < 20; i++) {
            pacman.move();
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }

        }
        //sets it to normal speed again 
        System.out.println("Step Size Before: " + PacmanCharacter.STEP_SIZE);
        pacman.setPoweredUp(false);
        pacman.superSpeed(pacman);
        System.out.println("Step Size After: " + PacmanCharacter.STEP_SIZE);

        //CASE 21: Brings inky back to life
        //Pre-Conditions: calls to respawn inky
        //Post Conditions: Draws inky at a random location, makes it cyan (default colour)
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 21: Brings inky back to life ");
        inky.respawn(inky);

        //CASE 22: Brings pacman back to life
        //Pre-Conditions: brings pacman back to life
        //Post Conditions:doesn't do it since pacman is already alive, lives are equal before and after
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 22: Brings pacman back to life ");
        System.out.println("");
        System.out.println("Number of Lives Before: " + pacman.getNumberOfLives());
        pacman.respawn(pacman);
        System.out.println("Number of Lives After: " + pacman.getNumberOfLives());

        //pauses before moving onto next case
        try {
            Thread.sleep(400);
        } catch (Exception e) {

        }

        //CASE 23: Brings inky back to life
        //Pre-Conditions: calls to respawn inky
        //Post Conditions: doesn't do it since inky is already alive
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 23: Brings inky back to life ");
        inky.respawn(inky);

        //CASE 24: Prints out all properties of pacman
        //Pre-Conditions: calls to string method
        //Post-Conditions: prints out all properties of pacman
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 24: Prints out all properties of pacman ");
        System.out.println(pacman.toString());

        //CASE 25: Prints out all properties of ghost (inky)
        //Pre-Conditions: calls to string method
        //Post-Conditions: prints out all properties of inky
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 25: Prints out all properties of inky (ghost) ");
        System.out.println(inky.toString());

        //CASE 26: Moves ghost using moveUp, moveDown, moveRight and moveLeft methods
        //Pre-Conditions: calls moveUp, moveDown, moveRight and moveLeft for ghost
        //Post Conditions: ghost ends up in new location
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 26: Moves ghost using moveUp, moveDown, moveRight and moveLeft methods ");

        for (int i = 0; i < 30; i++) {
            inky.moveDown();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < 30; i++) {
            inky.moveRight();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < 30; i++) {
            inky.moveUp();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < 30; i++) {
            inky.moveLeft();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

        //pauses before moving to next case
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        //CASE 27: Moves pacman using moveUp, moveDown, moveRight and moveLeft methods
        //Pre-Conditions: calls moveUp, moveDown, moveRight and moveLeft for pacman
        //Post Conditions: pacman ends up in new location
        System.out.println("-------------------------------------------------------");
        System.out.println("CASE 27: Moves pacman using moveUp, moveDown, moveRight and moveLeft methods ");
        
        //doesn't move 4 ghosts in different direction, because they may be at the edge of the screen and won't move
        //which would not show this case works. By using one ghost, it can be shown that all 4 methods work
        for (int i = 0; i < 30; i++) {
            pacman.moveDown();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < 30; i++) {
            pacman.moveRight();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < 30; i++) {
            pacman.moveLeft();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < 30; i++) {
            pacman.moveUp();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

    }
}
