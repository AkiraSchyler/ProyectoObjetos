import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class obstaclesControler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstaclesControlerLvl2 extends GameObjectsOfLevel2
{
    /**
     * Act - do whatever the obstaclesControler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int x=0;
    int y=250;
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
        Level2 world = (Level2) getWorld();
        ObjectCounter counter = world.getCounter();
        controlX();
        if(Greenfoot.getRandomNumber(7)==3){
            Knife knife = new Knife();
            randomCoordenates();
            counter.add(1);
            world.addObject(knife, x, y);
        }
        if(Greenfoot.getRandomNumber(7)==5){
            Calavera cala = new Calavera();
            randomCoordenates();
            world.addObject(cala, x, y);
            counter.add(1);
        }
        if(Greenfoot.getRandomNumber(10)==4){
            Beso beso = new Beso();
            randomCoordenates();
            world.addObject(beso, x, y);
            counter.add(1);

        }
    }

    public void controlX(){
        Level2 world = (Level2) getWorld();
        Timer timer = world.getTimer();
        if(timer.getTime()>80000){
            x=700;
        }else{
            x=0;
        }
    }

    public void countObstacles(){
        Level2 world = (Level2) getWorld();
        ObjectCounter counter = world.getCounter();
        int ayuda=counter.getValue();
        if(ayuda==0||ayuda==1||ayuda==2)
        {
            appears();
        }

    }
    public void stop(){
        Level2 world = (Level2) getWorld();
        MenuControllerLvl2 menu = world.getStop();
        Timer timer = world.getTimer();
        if(!menu.getStop() && timer.getTime()>20000){
            countObstacles();
        }else menu.getImage().setTransparency(200);
    }
    

    public void randomCoordenates()
    {
        if((Greenfoot.getRandomNumber(6))==3)
        {
            y=70;
        }
        if((Greenfoot.getRandomNumber(6))==5)
        {
            y=200;
        }
        if((Greenfoot.getRandomNumber(6))==4)
        {
            y=330;
        }
        if((Greenfoot.getRandomNumber(6))==5)
        {
            y=450;
        }

    }
}
