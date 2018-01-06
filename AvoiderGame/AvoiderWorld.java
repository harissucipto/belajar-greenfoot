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
        bkgMusic = new GreenfootSound("sounds/urban-jungle-looping.mp3");
        // Music credit: http://soundimage.org/sci-fi/
        bkgMusic.playLoop(); // Play the music
        
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
          enemySpawanRate += 2;
          enemySpeed++;
          nextLevel += 100;
      }
  }
  
  public void endGame() {
      bkgMusic.stop();
      AvoiderGameOverWorld go = new AvoiderGameOverWorld();
      Greenfoot.setWorld(go);
  }

    
}
