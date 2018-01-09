import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerItems here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class PowerItems extends SmoothMover
{
    protected double targetX, targetY, expireTime;
    protected double origX, origY;
    protected double duration;
    protected int counter;
    
    public PowerItems( int tX, int tY, int eT ) {
        targetX = tX;
        targetY = tY;
        expireTime = eT;
        counter = 0;
        duration = expireTime;
    }
    
    public void addedToWorld(World w) {
        origX = getX();
        origY = getY();
    }
    
    
    /**
     * Act - do whatever the PowerItems wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here
        easing();
        checkHitAvatar();
        checkExpire();
    } 
    
    protected abstract double curveX(double f);
    
    protected abstract double curveY(double f);
    
    protected abstract void checkHitAvatar();
    
    protected void easing() {
        double fX = ++counter / duration;
        double fY = counter / duration;
        System.out.println(fX);
        System.out.println(fY);
        fX = curveX(fX);
        fY = curveY(fY);
        setLocation((targetX * fX) + (origX * (1 - fX) ), 
        (targetY * fY) + (origY * (1 - fY)));
    }
    
    private void checkExpire() {
        if (expireTime-- < 0) {
            World w = getWorld();
            if ( w != null) w.removeObject(this);
        }
    }
}
