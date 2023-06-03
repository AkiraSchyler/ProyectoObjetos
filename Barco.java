import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Actor;

/**
 * Write a description of class Barco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barco extends GameObjectsOfLevel1
{
    private GifImage gifImage = new GifImage("BARCO_OFICIAL.gif");
    private GifImage inverted = new GifImage("barco.gif");
    /**
     * Act - do whatever the Barco wants to do. This method is called whenever
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
        Level1Scenario world = (Level1Scenario) getWorld();
        Timer timer = world.getTimer();
        if(timer.getTime()>120000 && timer.getTime()<187000){
            setImage(inverted.getCurrentImage());
        }else{
            setImage(gifImage.getCurrentImage());
        }
    }

    public void pause(){
        Level1Scenario world = (Level1Scenario) getWorld();
        MenuController menu = world.getStop();
        if(!menu.getStop()){
            handleKeys();
            moveBoat();
        }
    }

    private void moveBoat(){
        switch(direction){
            case DIRECTION_RIGHT:
                setLocation(getX() + 7, getY());

                break;
            case DIRECTION_LEFT:

                setLocation(getX() - 7, getY());

                break;
            case DIRECTION_UP:

                setLocation(getX() , getY() - 7);

                break;
            case DIRECTION_DOWN:

                setLocation(getX(), getY() + 7);

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
