import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacleslvl2 extends GameObjectsOfLevel2
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
        Level2 world = (Level2) getWorld();
        Timer timer = world.getTimer();
        if(timer.getTime()>73000&&speed==3)
        {
            speed=4;
        }
        if(timer.getTime()>120000 && speed==4){
            speed=6;
        }

    }

    public void move(){
        Level2 world = (Level2) getWorld();
        Timer timer = world.getTimer();
        changeSpeed();
        if(timer.getTime()<80000){
            setLocation(getX() + speed, getY());
        }else{
            setLocation(getX() - speed, getY());
        }
        ends();
    }

    void stopFall()
    {
       Level2 world = (Level2) getWorld();
        MenuControllerLvl2 menu = world.getStop();
        if(!menu.getStop()){
            move();
        }else setLocation(getX(), getY());
    }

    public void ends ()
    {
       Level2 world = (Level2) getWorld();
        ObjectCounter counter = world.getCounter();
        CounterOfLifes lifes = world.getLifes();
        if(touching1()||touching2()){
            counter.decreace(1);
            world.removeObject(this);
        }else if(touching3()){
            lifes.decreace(1);
            counter.decreace(1);
            world.removeObject(this);
        }
    }

}

