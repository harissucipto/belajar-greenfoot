import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Clover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public   class Clover extends PowerItems
{
    public Clover(int tX, int tY, int eT) {
        super(tX, tY, eT);
    }
    
    protected double curveX(double f) {
        return f;
    }
    
    protected double curveY(double f) {
        return Math.sin(4 * f);
        
    }
    
    protected void checkHitAvatar() {
        Avatar a = (Avatar) getOneIntersectingObject(Avatar.class);
        if (a != null) {
            a.lagControls();
            getWorld().removeObject(this);
        }
        
    }
    
    /**
     * Act - do whatever the Clover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
