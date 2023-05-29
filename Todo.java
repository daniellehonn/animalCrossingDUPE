import greenfoot.*; 

public class Todo extends Actor
{
    public static boolean shell11 = false;
    public static boolean shell12 = false;
    public static boolean shell13 = false;
    public static boolean shell14 = false;
    public static boolean shell21 = false;
    public static boolean shell24 = false;
    public static boolean shell31 = false;
    public static boolean shell34 = false;
    public static boolean shell41 = false;
    public static boolean shell42 = false;
    public static boolean shell43 = false;
    public static boolean shell44 = false;
    
    public static boolean fruit22 = false;
    public static boolean fruit23 = false;
    public static boolean fruit32 = false;
    public static boolean fruit33 = false;
    
    public static boolean flower22 = false;
    public static boolean flower23 = false;
    public static boolean flower32 = false;
    public static boolean flower33 = false;
    
    public static boolean deletedObject = false;
    
    private static boolean toggled = false;
    public void act()
    {
        if(Greenfoot.isKeyDown("t")){
            checkClicks();
            Greenfoot.delay(10);
        }
        trackToDos();
    }
    public void addedToWorld(World World){
        getImage().setTransparency(0);
    }
    public void checkClicks(){
        if(!toggled){
            getImage().setTransparency(255);
            toggled = true;
        }
        else{
            getImage().setTransparency(0);
            toggled = false;
        }
    }
    public void trackToDos(){
        boolean allFruits = fruit22&&fruit23&& fruit32&&fruit33;
        boolean allFlowers = flower22&&flower23&& flower32&&flower33;
        boolean allShells = shell11&&shell12&&shell13&&shell14&& shell21&&shell24&& shell31&&shell34&& shell41&&shell42&&shell43&&shell44;
        
        if(allFruits && allShells && allFlowers &&  deletedObject){
            GameOver go = new GameOver();
            getWorld().addObject(go, 640, 360);
            go.isGameOver = true;
        }
    }
}
