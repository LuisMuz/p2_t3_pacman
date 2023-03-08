import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private static final int MAX_WALLS = 12;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
        prepare();
    }

    private void prepare()
    {
        createScenario();

        Superfood superfood = new Superfood(30);
        addObject(superfood,521,219);
        Normalfood normalfood = new Normalfood(15);
        addObject(normalfood,159,523);
        Normalfood normalfood2 = new Normalfood(15);
        addObject(normalfood2,471,75);
        Superfood superfood2 = new Superfood(30);
        addObject(superfood2,299,278);
        superfood2.setLocation(299,274);
        Superfood superfood3 = new Superfood(30);
        addObject(superfood3,447,525);
        Normalfood normalfood3 = new Normalfood(15);
        addObject(normalfood3,219,424);
        Smallfood smallfood = new Smallfood(5);
        addObject(smallfood,405,419);
        Smallfood smallfood2 = new Smallfood(5);
        addObject(smallfood2,122,271);
        Smallfood smallfood3 = new Smallfood(5);
        addObject(smallfood3,473,300);
        Ghost ghost = new Ghost();
        addObject(ghost,298,323);

        addObject(new Pacman(), 75, 75);
    }
    
    private void createScenario(){
        int world [][] = 
        {
        {1,1,1,1,1,1,1,1,1,1,1,1},
        {2,0,0,0,0,0,0,0,0,0,0,3},
        {2,0,5,5,5,5,5,5,0,5,0,3},
        {2,0,5,0,0,0,0,0,0,5,0,3},
        {2,0,5,0,5,5,5,5,0,5,0,3},
        {2,0,0,0,5,0,0,5,0,0,0,3},
        {2,0,5,0,0,0,0,0,0,0,0,3},
        {2,0,5,0,5,5,5,5,0,5,0,3},
        {2,0,5,0,0,0,0,0,0,5,0,3},
        {2,0,5,5,5,0,0,5,5,5,0,3},
        {2,0,0,0,0,0,0,0,0,0,0,3},
        {4,4,4,4,4,4,4,4,4,4,4,4}
        };
        
        for(int i=0; i<MAX_WALLS; i++){
            for(int j=0; j<MAX_WALLS; j++){
                if(world[i][j] != 0)
                    createWall(world[i][j],j,i);
            }
        }
        
    }
    
    private void createWall(int typeWall,int x, int y){
        addObject(new Wall(typeWall), x*50+25, y*50+25);
    }
}
