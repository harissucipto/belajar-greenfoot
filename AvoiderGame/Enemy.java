import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor

{
    private int speed;
    private int timeToChange = 1;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + speed); // ketika musuh berhasil dibuat maka musuh bergerak terus turn 1 pixel ke bawah (y)
        changeDisposition(); // mengubah set image
        
        // cek hapus dan menghapus apabila object telah keluar screen
        checkRemove();
    }    
    
    public void checkRemove() {
        World w = getWorld();
        if ( getY() > w.getHeight() + 30) { // ketika object menyentuh scrren (+ 30 opsi karena object ditambahkan -30 pada world)
            w.removeObject(this);
        }
    }
    
    public void setSpeed(int s) {
        speed = s;
    }
    
    private void changeDisposition() {
        int ypos = getY();
        int worldHeight = getWorld().getHeight();
        int marker1 = (int) (worldHeight * 0.5);
        int marker2 = (int) (worldHeight * 0.75);
        int marker3 = (int) (worldHeight * 0.90);
        
        if ( timeToChange == 1 && ypos > marker1) {
            setImage("smiley4.png");
            timeToChange++;
        }
        else if (timeToChange == 2 && ypos > marker2) {
            setImage("smiley3.png");
            timeToChange++;
        }
        else if (timeToChange == 3 && ypos > marker3) {
            setImage("smiley5.png");
            timeToChange++;
        }
        
    }
        
}
