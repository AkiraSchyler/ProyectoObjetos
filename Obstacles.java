import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacles extends GameObjectsOfLevel1
{
    private int speed=3;
    /**
     * Act - do whatever the Level1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

    }

    public void changeSpeed()
    {
        Level1Scenario world = (Level1Scenario) getWorld();
        Timer timer = world.getTimer();
        if(timer.getTime()>73000&&speed==3)
        {
            speed=4;
        }
        if(timer.getTime()>120000 && speed==4){
            speed=5;
        }

    }

    public void move(){
        Level1Scenario world = (Level1Scenario) getWorld();
        Timer timer = world.getTimer();
        changeSpeed();
        if(timer.getTime()<120000){
            setLocation(getX(), getY() + speed);
        }else{
            setLocation(getX(), getY() - speed);
        }
        ends();
    }

    void stopFall()
    {
        Level1Scenario world = (Level1Scenario) getWorld();
        MenuController menu = world.getStop();
        if(!menu.getStop()){
            move();
        }else setLocation(getX(), getY());
    }

    public void ends ()
    {
        Level1Scenario world = (Level1Scenario) getWorld();
        ObjectCounter counter = world.getCounter();
        CounterOfLifes lifes = world.getLifes();
        if(touching1()||touching2()){
            counter.decreace(1);
            getWorld().removeObject(this);
        }else if(touching3()){
            lifes.decreace(1);
            counter.decreace(1);
            getWorld().removeObject(this);
        }
    }

}

