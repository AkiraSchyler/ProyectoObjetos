import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    GifImage arco = new GifImage("arcoiris.gif"); 
    GifImage arcoInver = new GifImage("arcoinver.gif"); 
    Life life = new Life();
    Timer timer = new Timer();
    private int lives;
    Corazon cora = new Corazon();
    Floor floor = new Floor();
    Floor floor2 = new Floor();
    Floor floor3 = new Floor();
    Floor floor4 = new Floor();
    Floor roof1 = new Floor();
    Floor roof2 = new Floor();
    Floor roof3 = new Floor();
    Floor roof4 = new Floor();
    GreenfootSound bRain = new GreenfootSound("Black Rainbows.mp3" );
    MenuControllerLvl2 menu = new MenuControllerLvl2();
    ObjectCounter counter = new ObjectCounter();
    CounterOfLifes lifes = new CounterOfLifes();
    ObstaclesControlerLvl2 obstacles = new ObstaclesControlerLvl2();
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);  
        addObject(cora, 600, 230);
        addObject(floor, 800, 70);
        floor.getImage().rotate(90);
        floor.getImage().setTransparency(00);
        addObject(floor2, 800, 200);
        floor2.getImage().rotate(90);
        floor2.getImage().setTransparency(00);
        addObject(floor3, 800, 330);
        floor3.getImage().rotate(90);
        floor3.getImage().setTransparency(00);
        addObject(floor4, 800, 450);
        floor4.getImage().rotate(90);
        floor4.getImage().setTransparency(00);
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

    public MenuControllerLvl2 getStop(){
        return menu;
    }

    public Timer getTimer(){
        return timer;
    }

    public GreenfootSound getSound(){
        return bRain;
    }

    private void prepare(){
        addObject(counter, 60, 60);
        counter.getImage().setTransparency(0);
        addObject(lifes, 100, 30);
        addObject(menu, 300, 250);
        menu.getImage().setTransparency(0);
    }

    public void act ()
    {
        prepare();
        showText("Valor: " + timer.getTime(), 60, 120);
        appearsMenu();
        GAMEOVER();
        nextLevel();

    }

    public void changeBackground(){
        if(timer.getTime()<80000){
            setBackground(arco.getCurrentImage());
        }else{

            setBackground(arcoInver.getCurrentImage());
            setBackground(arcoInver.getCurrentImage());
            addObject(roof1, -5, 70);
            roof1.getImage().setTransparency(0);
            addObject(roof2, -5, 200);
            roof2.getImage().setTransparency(0);
            removeObject(floor);
            removeObject(floor2);

            addObject(roof3, -5, 330);
            floor4.getImage().rotate(90);
            roof3.getImage().setTransparency(0);
            addObject(roof4, -5, 400);
            floor4.getImage().rotate(90);
            roof4.getImage().setTransparency(0);
            removeObject(floor3);
            removeObject(floor4);
        }
    }

    public void appearsMenu(){
        if(menu.getStop()){
            menu.getImage().setTransparency(200);
            bRain.pause();
        }else{
            changeBackground();
            menu.getImage().setTransparency(0);
            bRain.play();
        }
    }

    public void GAMEOVER(){
        lives=lifes.getValue();
        if(lives==0){
            GAEMOVER go = new GAEMOVER();
            Greenfoot.setWorld(go);
            bRain.stop();
        }
    }

    public void nextLevel(){
        if(timer.getTime()>169000){
            bRain.stop();
            END go = new END();
            Greenfoot.setWorld(go);
        }
    }

}

