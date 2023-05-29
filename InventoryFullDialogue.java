import greenfoot.*;

public class InventoryFullDialogue extends Actor
{    
    static boolean displayed = false;
    public InventoryFullDialogue()
    {        
    }
    public void addedToWorld(World world)
    {
        displayed = true;
    }
    public void act() 
    {        
        if (Greenfoot.mouseClicked(this))
        {   
            displayed = false;
            getWorld().removeObject(this);           
        }
    }  
    public static boolean hasDisplayed()
    {
        return displayed == true;
    }
}
