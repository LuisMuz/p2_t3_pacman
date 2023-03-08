import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ghost extends Actor
{
    private int OFFSET = 1;
    
    public Ghost(){
        setImage("images/ghost.png");
    }
    
    public void act()
    {
        setLocation(getX() + OFFSET, getY());
        if(isTouching(Wall.class)){
            OFFSET *=-1;
        }
    }
}
