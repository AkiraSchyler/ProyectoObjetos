import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameObjectsOfLevel2 extends Actor
{

    /**
     * Act - do whatever the GameObjects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    public boolean touching1()
    {
        return isTouching(Floor.class);
    }

    public boolean touching2()
    {
        return isTouching(Obstacleslvl2.class);   
    }

    public boolean touching3()
    {
        return isTouching(Corazon.class);   
    }

}
