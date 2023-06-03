import greenfoot.*;
import java.util.ArrayList;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1Scenario extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    GifImage Mar1 = new GifImage("mar1.gif"); 
    GifImage Mar2 = new GifImage("mar2.gif");
    GifImage Mar3 = new GifImage("REDSEA.gif"); 
    Life life = new Life();
    Timer timer = new Timer();
    private int lives;
    Barco barco = new Barco();
    Floor floor = new Floor();
    Floor floor2 = new Floor();
    Floor roof1 = new Floor();
    Floor roof2 = new Floor();
    GreenfootSound IsleUnto = new GreenfootSound("Isle Unto Thyself.mp3" );
    MenuController menu = new MenuController();
    ObjectCounter counter = new ObjectCounter();
    CounterOfLifes lifes = new CounterOfLifes();
    ObstaclesControler obstacles = new ObstaclesControler();
    public Level1Scenario()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 700, 1);  
        addObject(barco, 250, 600);
        addObject(floor, 380, 800);
        floor.getImage().setTransparency(0);
        addObject(floor2, 150, 800);
        floor2.getImage().setTransparency(0);
        addObject(obstacles, 0, 0);
        obstacles.getImage().setTransparency(0);
        addObject(life, 30, 30);
        addObject(timer, 0, 0);
        timer.mark();    
    }

    public ObjectCounter getCounter(){
        return counter;
    }

    public CounterOfLifes getLifes(){
        return lifes;
    }

    public MenuController getStop(){
        return menu;
    }

    public Timer getTimer(){
        return timer;
    }

    public GreenfootSound getSound(){
        return IsleUnto;
    }

    private void prepare(){
        addObject(counter, 60, 60);
        counter.getImage().setTransparency(0);
        addObject(lifes, 100, 30);
        addObject(menu, 250, 200);
        menu.getImage().setTransparency(0);
    }

    public void act ()
    {
        prepare();

        showText("Valor: " + timer.getTime(), 60, 120);

       
        appearsMenu();
        nextLevel();
        GAMEOVER();

    }

    public void changeBackground(){
        if(timer.getTime()<73000 || timer.getTime()>187000){
            setBackground(Mar1.getCurrentImage());
        }else{
            if(timer.getTime()<118000){
                setBackground(Mar2.getCurrentImage());

            }else{//third part of the level
                setBackground(Mar3.getCurrentImage());
                addObject(roof1, 150, 0);//the boundaries exchanges
                roof1.getImage().setTransparency(0);
                addObject(roof2, 380, 0);
                roof2.getImage().setTransparency(0);
                removeObject(floor);
                removeObject(floor2);
            }
        }
    }

    public void appearsMenu(){
        if(menu.getStop()){
            menu.getImage().setTransparency(200);
            IsleUnto.pause();
        }else{
            changeBackground();
            menu.getImage().setTransparency(0);
            IsleUnto.play();
        }
    }

    public void GAMEOVER(){
        lives=lifes.getValue();
        if(lives==0){
            GAEMOVER go = new GAEMOVER();
            Greenfoot.setWorld(go);
            IsleUnto.stop();
        }
    }

    public void nextLevel(){//227
        if(timer.getTime()>227000){
            Level2 go = new Level2();
            IsleUnto.stop();
            Greenfoot.setWorld(go);
        }
    }

}
