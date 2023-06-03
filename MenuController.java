import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuController extends GameObjectsOfLevel1
{
    private boolean stop=false;
    private int value;
    private int zHandled=30;
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MenuController(){
        value=0;
        
    }
  
    public void act()
    {
        // Add your action code here.
        appear();
    }
    public void appear(){
        Level1Scenario world = (Level1Scenario) getWorld();
        Timer timer = world.getTimer();
        if(Greenfoot.isKeyDown("z") && zHandled==30 && !stop){
            zHandled--; 
            stop=true;
            value=timer.getTime();
        }else if(Greenfoot.isKeyDown("x" ) && zHandled==30 && stop){
            zHandled--;
            stop=false;
            timer.setTime(value);
            timer.mark();
        }
        if(zHandled>0 && zHandled<30){
            zHandled--;
        }else if(zHandled==0){
            zHandled=30;
        }
        if(Greenfoot.isKeyDown("c")){
           stop=false;
           timer.setTime(0);
           timer.mark();
           world.getSound().stop();
        }
    }
    
    public boolean getStop(){
        return stop;
    }
    
    
}
