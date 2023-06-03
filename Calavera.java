import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class calavera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calavera extends Obstacleslvl2
{
    private GifImage gifImage = new GifImage("masc.gif");
    private GifImage inverted = new GifImage("minver.gif");
    /* * Act - do whatever the Barco wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        changeImages();
        stopFall();
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

}
