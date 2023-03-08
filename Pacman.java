import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pacman extends Actor
{
    private static final int COUNTDOWN = 13;
    private static final int DIR_RIGHT = 0;
    private static final int DIR_LEFT = 1;
    private static final int DIR_UP = 2;
    private static final int DIR_DOWN = 3;
    private static final int OFFSET = 2;
    
    private int mouthDelay = COUNTDOWN;

    private String [][] images;
    private int imageIndex = 0;
    private int direction = 0;
    
    private int score = 0;
    
    public Pacman(){
        images = new String [4][2];
        
        prepareImageCollection();
        setImage(images[0][0]);
    }
    
    public void act()
    {
        if(score == -1){
            World world = getWorld();
            world.showText("You have lost",world.getWidth()/2, 325);
        }else if(score < 150){
            movePacman();
            handleKeys();
            handleImageSelector();
            checkFoodCollisions();
            updateHud();
            checkSafety();
        }else{
            World world = getWorld();
            world.showText("You have won",world.getWidth()/2, 325);
        }
    }
    
    private void movePacman(){
        switch(direction){
            case DIR_RIGHT:
                setLocation(getX() + OFFSET, getY());
                break;
            case DIR_LEFT:
                setLocation(getX() - OFFSET, getY());
                break;
            case DIR_UP:
                setLocation(getX(), getY() - OFFSET);
                break;
            case DIR_DOWN:
                setLocation(getX(), getY() + OFFSET);
                break;
        }
        
        if(isTouching(Wall.class)){
            switch(direction){
                case DIR_RIGHT:
                    setLocation(getX() - OFFSET, getY());
                    break;
                case DIR_LEFT:
                    setLocation(getX() + OFFSET, getY());
                    break;
                case DIR_UP:
                    setLocation(getX(), getY() + OFFSET);
                    break;
                case DIR_DOWN:
                    setLocation(getX(), getY() - OFFSET);
                    break;
            }
        }
    }
    
    private void prepareImageCollection(){
        images[DIR_RIGHT][0] = "images/Pacman templates/pacman-close.png";
        images[DIR_RIGHT][1] = "images/Pacman templates/pacman-open.png";
        images[DIR_LEFT][0] = "images/Pacman templates/pacman-close-left.png";
        images[DIR_LEFT][1] = "images/Pacman templates/pacman-open-left.png";
        images[DIR_UP][0] = "images/Pacman templates/pacman-close-up.png";
        images[DIR_UP][1] = "images/Pacman templates/pacman-open-up.png";
        images[DIR_DOWN][0] = "images/Pacman templates/pacman-close-down.png";
        images[DIR_DOWN][1] = "images/Pacman templates/pacman-open-down.png";
    }
    
    private void handleKeys(){
        if(Greenfoot.isKeyDown("left")){
            direction = DIR_LEFT;
        }else if(Greenfoot.isKeyDown("right")){
            direction = DIR_RIGHT;
        }else if(Greenfoot.isKeyDown("up")){
            direction = DIR_UP;
        }else if(Greenfoot.isKeyDown("down")){
            direction = DIR_DOWN;
        }
    }
    
    private void handleImageSelector(){
        mouthDelay --;
        if(mouthDelay == 0){
            imageIndex = (imageIndex + 1) % 2;
            setImage(images[direction][imageIndex]);
            mouthDelay = COUNTDOWN;
        }
    }
    
    private void checkFoodCollisions(){
        Food food = (Food)this.getOneIntersectingObject(Food.class);
        
        if(food != null){
            score += food.getPoints();
            this.getWorld().removeObject(food);
        }
        
        
    }
    
    private void checkSafety(){
        Ghost ghost = (Ghost)this.getOneIntersectingObject(Ghost.class);
        
        if(ghost != null){
            score = -1;
        }
    }
    
    private void updateHud(){
        World world = getWorld();
        world.showText("Score: " + score, world.getWidth() - 75,20);
    }
    
    public int getScore(){
        return score;
    }
    
    protected void setScore(int newScore){
        score = newScore;
    }
    
}
