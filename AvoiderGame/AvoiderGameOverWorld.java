import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AvoiderGameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AvoiderGameOverWorld extends World
{
    private GreenfootSound bkgMusic; //variable buat nampung suara bg saat sedih

    /**
     * Constructor for objects of class AvoiderGameOverWorld.
     * 
     */
    public AvoiderGameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // Initilize the music
        bkgMusic = new GreenfootSound("sounds/urban-jungle-looping.mp3");
        // Music credit: http://soundimage.org/sci-fi/
        bkgMusic.playLoop(); // Play the music
    }
    public void act() {
        // Restar the game if the user clicks the mouse anywhere
        if (Greenfoot.mouseClicked(this)) {
            bkgMusic.stop();
            AvoiderWorld world = new AvoiderWorld();
            Greenfoot.setWorld(world);
        }
    }
}
