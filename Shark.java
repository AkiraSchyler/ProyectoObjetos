import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shark extends Obstacles
{
    private GifImage gifImage = new GifImage("shark.gif");
    private GifImage inverted = new GifImage("Tiburon invertido.gif" );
    /**
     * Act - do whatever the Barco wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        changeImages();
        stopFall();
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
}
