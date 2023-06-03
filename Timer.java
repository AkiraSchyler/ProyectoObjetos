import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

public class Timer extends Actor
{
    private int lastMark =(int)System.currentTimeMillis();
    private int time;
    private int runTime;
    private int otra;
    int zHandled=90;
    public Timer(){
        time=0;
        otra=0;
    }
    /**
     * Marks the current time.  You can then in future call
     * millisElapsed() to find out the elapsed milliseconds
     * since this mark() call was made.
     * 
     * A second mark() call will reset the mark, and millisElapsed()
     * will start increasing from zero again.
     */
    public void mark()
    {
        lastMark = (int)(System.currentTimeMillis());
    }

    /**
     * Returns the amount of milliseconds that have elapsed since mark()
     * was last called.  This timer runs irrespective of Greenfoot's
     * act() cycle, so if you call it many times during the same Greenfoot frame,
     * you may well get different answers.
     */
    public int getTime()
    {
        //Level1Scenario world = (Level1Scenario) getWorld();
        //MenuController menu = world.getStop();
        
            runTime=((int)System.currentTimeMillis()-lastMark);
        if (Greenfoot.isKeyDown("z" ) && zHandled==30){
            zHandled--;
            time=time+runTime;
        }
        if(zHandled>0 && zHandled<30){
            zHandled--;
        }else if(zHandled==0){
            zHandled=30;
        }
        otra=runTime+time;
        return(otra);
    }
     
    public void setTime(int value){
        time=value;
    }

}
