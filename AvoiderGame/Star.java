import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    int speed = 1;
    
    // constructor class
    public Star() {
        GreenfootImage img = new GreenfootImage(10, 10);
        img.setColor(Color.WHITE);
        img.fillOval(0, 0, 10, 10);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.

        setLocation(getX() , getY() + speed);
        checkRemove();
        checkTwinkle();
    }
    
    private void checkRemove() {
        World w = getWorld();
        if (getY() > w.getHeight() + 30) {
            w.removeObject(this);
        }

        
    }
    
    public void setSpeed( int s ) {
        speed = s;
    }
}
