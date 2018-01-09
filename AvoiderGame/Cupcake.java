import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cupcake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cupcake extends PowerItems
{
    public Cupcake( int tX, int tY, int eT) {
       super(tX, tY, eT);
    
    }
    
    protected double curveX(double f) {
        return f;
    }
    
    protected double curveY(double f) {
        return f;
        
    }
    
    
    protected void checkHitAvatar() {
        Avatar a = (Avatar) getOneIntersectingObject(Avatar.class);
        if ( a != null ) {
            a.stun();
            getWorld().removeObject(this);
        }
    }
    
    
    /**
     * Act - do whatever the Cupcake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
