import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Avatar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Avatar extends Actor
{
    private int health = 3;
    private int hitDelay = 0;
    private int nextImage = 0;
    private Eye leftEye;
    private Eye rightEye;
    
    
    
    /**
     * Act - do whatever the Avatar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followMouse();
        checkForCollisions();
    } 
    
    private void followMouse() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if ( mi != null) {
            setLocation(mi.getX(), mi.getY());
            leftEye.setLocation(getX() - 10, getY() - 8);
            rightEye.setLocation(getX() + 10, getY() - 8);
        }
    }
    
    private void checkForCollisions() { // ketika actor bersentuhan dengan musuh
       Actor enemy = getOneIntersectingObject(Enemy.class);
       if ( hitDelay == 0 && enemy != null) {
           if (health == 0) {
               AvoiderWorld world = (AvoiderWorld) getWorld();
               world.endGame();
           } else {
               health--;
               setImage("skull" + ++nextImage + ".png");
               hitDelay = 50;
           }
       }
       
       if ( hitDelay > 0 ) hitDelay--;
    }
    
    
    protected void addedToWorld(World w) {
        leftEye = new Eye();
        rightEye = new Eye();
       
        w.addObject(leftEye, getX() - 10, getY() - 8);
        w.addObject(rightEye, getX() + 10, getY() - 8);
    }
}
