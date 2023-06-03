import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    GifImage espace = new GifImage("MenuFondo.gif"); 
    GifImage espace2 = new GifImage("MenuFondo.gif"); 
    GreenfootImage title = new GreenfootImage("title.png");
    GreenfootImage z = new GreenfootImage("press z.png");
    GreenfootImage x = new GreenfootImage ("musica.png");
    GreenfootImage y = new GreenfootImage ("creditos.png");
    GreenfootSound mar = new GreenfootSound("0-30.mp3" );
    Timer timer = new Timer();
    GreenfootSound intro = new GreenfootSound("FINAL.mp3");
    GifImage fall = new GifImage("marcayendo.gif"); 
    GifImage trans = new GifImage("transcicion.gif"); 
    MenuController menu = new MenuController();
    private boolean start=false;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

    }

    public void act(){

        start();
        startz();

    }

    public MenuController getStop(){
        return menu;
    }

    public void initialScene(int value){
        if(value!=5){
            setBackground(espace.getCurrentImage());
            getBackground().drawImage(title, 100, 100);
            getBackground().drawImage(z, 200, 200);
            mar.play();
        }else{
            setBackground(espace2.getCurrentImage());
            getBackground().drawImage(x, 100, 200);
            getBackground().drawImage(y, 100, 300);

        }

    }

    public void start(){

        if(start){
            initialScene(5);
            mar.stop();
            intro.play();
            showText("Valor: " + timer.getTime(), 60, 120);
            if(timer.getTime()>53000){
                setBackground(fall.getCurrentImage());
                if(timer.getTime()>70000){
                    setBackground(trans.getCurrentImage());
                    if(timer.getTime()>74000){
                        Level1Scenario go = new Level1Scenario();
                        intro.stop();
                        Greenfoot.setWorld(go);
                    }
                }
            }
        }else {initialScene(0);}
    }

    public void startz(){
        if(Greenfoot.isKeyDown("z") && !start){
            start= true;
            timer.mark();
        }
    }
}
