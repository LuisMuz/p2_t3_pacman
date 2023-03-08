import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Food extends Actor
{
    protected int points;
    
    public Food(int points){
        this.points = points;
    }
    
    public void act()
    {
        
    }
    
    public int getPoints(){
        return points;
    }
}
