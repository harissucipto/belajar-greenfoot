import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + 2); // ketika musuh berhasil dibuat maka musuh bergerak terus turn n + pixel ke bawah (y)
        
        turn(10); // seberapa cepat actor berputar
        
        // cek hapus dan menghapus apabila object telah keluar screen
        checkRemove();
        
    }    
    
    public void checkRemove() {
        World w = getWorld();
        if ( getY() > w.getHeight() + 30) { // ketika object menyentuh scrren (+ 30 opsi karena object ditambahkan -30 pada world)
            w.removeObject(this);
        }
    }
        
}
