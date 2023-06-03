import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Actor;

/**
 * Write a description of class Corazon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Corazon extends GameObjectsOfLevel2
{
    private GifImage gifImage = new GifImage("cora.gif");
    private GifImage inverted = new GifImage("cinver.gif");
    /**
     * Act - do whatever the Corazon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private  final int DIRECTION_RIGHT = 0;
    private  final int DIRECTION_LEFT = 1;
    private  final int DIRECTION_UP = 2;
    private  final int DIRECTION_DOWN = 3;
    private  final int NONE = 4;
    private int direction = NONE;

    public void act()
    {
        changeImages();
        pause();
    }

    public void changeImages(){
        Level2 world = (Level2) getWorld();
        Timer timer = world.getTimer();
        if(timer.getTime()>80000){
            setImage(inverted.getCurrentImage());
        }else{
            setImage(gifImage.getCurrentImage());
        }
    }

    public void pause(){
        Level2 world = (Level2) getWorld();
        MenuControllerLvl2 menu = world.getStop();
        if(!menu.getStop()){
            handleKeys();
            moveBoat();
        }
    }

    private void moveBoat(){
        switch(direction){
            case DIRECTION_RIGHT:
                setLocation(getX() + 5, getY());

                break;
            case DIRECTION_LEFT:

                setLocation(getX() - 5, getY());

                break;
            case DIRECTION_UP:

                setLocation(getX() , getY() - 5);

                break;
            case DIRECTION_DOWN:

                setLocation(getX(), getY() + 5);

                break;
            case NONE:
                setLocation(getX(), getY());
                break;

        }
    }

    private void handleKeys(){
        if(Greenfoot.isKeyDown("left")){
            direction = DIRECTION_LEFT;

        }else if(Greenfoot.isKeyDown("right")){
            direction=DIRECTION_RIGHT;

        }else if(Greenfoot.isKeyDown("up")){
            direction=DIRECTION_UP;

        }else if(Greenfoot.isKeyDown("down")){
            direction=DIRECTION_DOWN;

        }else{
            direction=NONE;
        }
    }
}
