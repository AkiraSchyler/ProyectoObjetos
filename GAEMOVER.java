import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GAEMOVER here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GAEMOVER extends World
{

    /**
     * Constructor for objects of class GAEMOVER.
     * 
     */
    public GAEMOVER()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    public void act(){
        if(Greenfoot.isKeyDown("z")){
            
            Level1Scenario go = new Level1Scenario();
             Greenfoot.setWorld(go);
        }
    }
}
