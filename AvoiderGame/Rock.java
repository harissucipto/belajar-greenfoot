import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  class  Rock extends PowerItems
{
    public Rock (int tX, int tY, int eT) {
        super(tX, tY, eT);
    }
    
    protected double curveX(double f) {
        return f;
    }
    
    protected double curveY(double f) {
        return f * f * f;
    }
    
    protected void checkHitAvatar() {
        Avatar a = (Avatar) getOneIntersectingObject(Avatar.class);
        if (a != null) {
            a.addHealth();
            getWorld().removeObject(this);
        }
        
    }
    
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // Add your action code here.
    }    
}
