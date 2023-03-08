import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Wall extends Actor
{
    public Wall(int type){
        setImage(setWallSkin(type));
    }
    
    public void act()
    {
        
    }
    
    private String setWallSkin(int type){
        String skin = "";
        
        switch(type){
            case 1:
                skin = "images/Wall types/upper_wall.png";
                break;
            case 2:
                skin = "images/Wall types/left_wall.png";
                break;
            case 3:
                skin = "images/Wall types/right_wall.png";
                break;
            case 4:
                skin = "images/Wall types/lower_wall.png";
                break;
            default:
                skin = "images/Wall types/wall.png";
                break;
        }
        return skin;
    }
}
