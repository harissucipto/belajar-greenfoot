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
    private Counter scoreBoard; // varaible untuk counter score
    private int enemySpawanRate = 20;
    private int enemySpeed = 1;
    private int nextLevel = 100;
    
    private int cupcakeFrequency = 10;
    private int cloverFrequency = 10;
    private int rockFrequency = 1;
    
    /**
     * Constructor for objects of class AvoiderWorld.
     * 
     */
    public AvoiderWorld() /// constructor
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // set flase when world is unbounding (kondisi dimana actor bisa melewati pembatas screen)
        super(600, 400, 1, false); 
        
        // Initilize the music
        // bkgMusic = new GreenfootSound("sounds/urban-jungle-looping.mp3");
        // Music credit: http://soundimage.org/sci-fi/
        // bkgMusic.playLoop(); // Play the music
        
        setPaintOrder(Eye.class, Avatar.class, Enemy.class, Counter.class);
        prepare();
        generateInitialStarField();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Avatar avatar = new Avatar();
        addObject(avatar,287,232);
        scoreBoard = new Counter("Score: ");
        addObject(scoreBoard, 70, 20);
    }
    
    /**
     * Act when game is started.
     * 
   */
  public void act() {
      // Randomly add enimies to the world
      generateEnemies();
      generatePowerItems();
      
      generateStars(-1);
      
      increaseLevel();
  }
  
  private void generateEnemies() {
      if (Greenfoot.getRandomNumber(1000) < enemySpawanRate) { // berapa persen musuh keluar ke screen
          Enemy e = new Enemy();
          e.setSpeed(enemySpeed);
          addObject(e, Greenfoot.getRandomNumber(getWidth() - 20) + 10, -30);
          // Give us some points for facing yet another enemy
          scoreBoard.setValue(scoreBoard.getValue() + 1);
          
      }
  }
  
  private Actor createPowerItem(int type,int targetX, int targetY, int expireTime) {
      System.out.println("power item berhasil dibuat" + targetX + targetY );
      switch (type) {
          case 0:
            return new Cupcake(targetX, targetY, expireTime);
          case 1:
            return new Clover(targetX, targetY, expireTime);
          case 2:
            return new Rock(targetX, targetY, expireTime);
 
      }

      return null;
      
  }
  
  private void generatePowerItem( int type, int freq) {
      if (Greenfoot.getRandomNumber(1000) < freq) {
          int targetX = Greenfoot.getRandomNumber(getWidth() - 80) + 40;
          int targetY = Greenfoot.getRandomNumber(getHeight() / 2) + 20;
          Actor a = createPowerItem(type, targetX, targetY, 100);
          if ( Greenfoot.getRandomNumber(100) < 50 ) {
              addObject(a, getWidth() + 20, Greenfoot.getRandomNumber(getHeight() / 2) + 30);
          } else {
              addObject(a, -20, Greenfoot.getRandomNumber(getHeight() / 2) + 30);
          }
          
      }
  }
  
  private void generatePowerItems() {
      generatePowerItem(0, cupcakeFrequency);
      generatePowerItem(1, cloverFrequency);
      generatePowerItem(2, rockFrequency);
  }
  
  private void generateStars(int yLoc) {
      if (Greenfoot.getRandomNumber(1000) < 350) {
          Star s = new Star();
          GreenfootImage image = s.getImage();
          
          if (Greenfoot.getRandomNumber(1000) < 300) {
              // this is a close bright star
              s.setSpeed(3);
              image.setTransparency(
                Greenfoot.getRandomNumber(25) + 225
              );
              image.scale(4, 4);
              
           } else {
              // this is a further dim star
              s.setSpeed(2);
              image.setTransparency(
                Greenfoot.getRandomNumber(50) + 100
              );
              image.scale(2, 2);
               
            }
          s.setImage(image);
          addObject(s, Greenfoot.getRandomNumber(getWidth() -20) + 10, yLoc);
      }
  }
  
  private void generateInitialStarField() {
      for (int i = 0; i < getHeight(); i++) {
          generateStars(i);
      }
  }
  
  private void increaseLevel() {
      int score = scoreBoard.getValue();
      
      if (score > nextLevel) {
          enemySpawanRate += 3;
          enemySpeed++;
          cupcakeFrequency += 3;
          cloverFrequency += 3;
          rockFrequency += 2;
          nextLevel += 50;
      }
  }
  
  public void endGame() {
      
  }

    
}
