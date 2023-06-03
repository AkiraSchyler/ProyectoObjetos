import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class obstaclesControler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstaclesControler extends GameObjectsOfLevel1
{
    /**
     * Act - do whatever the obstaclesControler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int x=250;
    int y=0;
    Timer timer = new Timer();
    boolean stop=false;
    Obstacles Obstacles = new Obstacles();

    public void act()
    {
        timer.mark();
        stop();
    }

    public void appears()
    {
        Level1Scenario world = (Level1Scenario) getWorld();
        ObjectCounter counter = world.getCounter();
        controlY();
        if(Greenfoot.getRandomNumber(6)==2){
            Buoy buoy = new Buoy();
            randomCoordenates();
            counter.add(1);
            getWorld().addObject(buoy, x, y);
        }
        if(Greenfoot.getRandomNumber(6)==3){
            Shark shark = new Shark();
            randomCoordenates();
            getWorld().addObject(shark, x, y);
            counter.add(1);
        }
        if(Greenfoot.getRandomNumber(6)==4){
            Wave wave = new Wave();
            randomCoordenates();
            getWorld().addObject(wave, x, y);
            counter.add(1);

        }
    }

    public void controlY(){
        Level1Scenario world = (Level1Scenario) getWorld();
        Timer timer = world.getTimer();
        if(timer.getTime()>120000){
            y=700;
        }else{
            y=0;
        }
    }

    public void countObstacles(){
        Level1Scenario world = (Level1Scenario) getWorld();
        ObjectCounter counter = world.getCounter();
        int ayuda=counter.getValue();
        if(ayuda==0||ayuda==1)
        {
            appears();
        }

    }
    public void stop(){
        Level1Scenario world = (Level1Scenario) getWorld();
        MenuController menu = world.getStop();
        Timer timer = world.getTimer();
        if(!menu.getStop() && timer.getTime()>12000){
            countObstacles();
        }else menu.getImage().setTransparency(200);
    }
    

    public void randomCoordenates()
    {
        if((Greenfoot.getRandomNumber(6))==3)
        {
            x=80;
        }
        if((Greenfoot.getRandomNumber(6))==5)
        {
            x=250;
        }
        if((Greenfoot.getRandomNumber(6))==4)
        {
            x=450;
        }

    }
}
