import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class END here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class END extends World
{
    GreenfootImage end = new GreenfootImage("fin.png");
    GreenfootSound white = new GreenfootSound("whiteball.mp3" );
    /**
     * Constructor for objects of class END.
     * 
     */
    public END()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    public void act(){
        white.play();
        getBackground().drawImage(end, 200, 200);
    }
}
