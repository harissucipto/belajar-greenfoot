import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AvoiderWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AvoiderWorld extends World
{
    private GreenfootSound bkgMusic; // bikin variable agar dapat diakses semua method

    /**
     * Constructor for objects of class AvoiderWorld.
     * 
     */
    public AvoiderWorld()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // set flase when world is unbounding (kondisi dimana actor bisa melewati pembatas screen)
        super(600, 400, 1, false); 
        
        // Initilize the music
        bkgMusic = new GreenfootSound("sounds/urban-jungle-looping.mp3");
        // Music credit: http://soundimage.org/sci-fi/
        bkgMusic.playLoop(); // Play the music
        
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
      if (Greenfoot.getRandomNumber(1000) < 20) { // berapa persen musuh keluar ke screen
          Enemy e = new Enemy();
          addObject(e, Greenfoot.getRandomNumber(getWidth() - 20) + 10, -30);
          
      }
  }
  public void endGame() {
      bkgMusic.stop();
      AvoiderGameOverWorld go = new AvoiderGameOverWorld();
      Greenfoot.setWorld(go);
  }
    
}
