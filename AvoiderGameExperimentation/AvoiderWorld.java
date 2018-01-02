import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AvoiderWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AvoiderWorld extends World
{

    /**
     * Constructor for objects of class AvoiderWorld.
     * 
     */
    public AvoiderWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // set flase when world is unbounding (kondisi dimana actor bisa melewati pembatas screen)
        super(600, 400, 1, false); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Avatar avatar = new Avatar();
        addObject(avatar,301,204);
    }
    
    /**
     * Act when game is started.
     * 
   */
  public void act() {
      // Randomly add enimies to the world
      // atau random spawan enmy
      if (Greenfoot.getRandomNumber(1000) < 60) { // berapa persen musuh spwan keluar ke screen
          Enemy e = new Enemy();
          addObject(e, Greenfoot.getRandomNumber(getWidth() - 20) + 10, -30);
          
      }
  }
    
}
