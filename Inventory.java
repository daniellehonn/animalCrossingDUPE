import greenfoot.*;
import java.util.*;
public class Inventory extends Actor
{    
    public static boolean inventoryShowing = false;
    public static Todo todo = new Todo();
    public ArrayList <Actor> inventoryObjects = new ArrayList <Actor>();
    public ArrayList <Actor> toBeRemoved = new ArrayList <Actor>();
    private static final int INVENTORY_SIZE = 30;
    private static final int[][] INVENTORY_COORDINATES = {{310, 190, 1},{385, 177, 2},{458, 161, 3},{530, 154, 4},{607, 146, 5},{682, 146, 6},{752, 154, 7},{825, 161, 8},{887, 177, 9},{961, 190, 10},
                                                          {310, 270, 11},{385, 255, 12},{458, 242, 13},{530, 234, 14},{607, 227,  15},{682, 227, 16},{752, 234, 17},{825, 242, 18},{887, 255, 19},{961, 270, 20},
                                                          {310, 351, 21},{385, 333, 22},{458, 318, 23},{530, 311, 24},{607, 306, 25},{682, 306, 26},{752, 311, 27},{825, 318, 28},{887, 333, 29},{961, 351, 30}};
    public void act() 
    {
        checkInv();
        if (inventoryShowing && Global.collectedObjects.size()>0 && Greenfoot.mouseClicked(null)){   
            try{
                removeInv();  
            } catch(Exception e){
                
            }      
        }
    }
    public static boolean addToInventory(Actor x)
    {
        if (Global.collectedObjects.size() < INVENTORY_SIZE)
        {
            Global.collectedObjects.add(x);
            return false;
        }
        return true;
    }
    public static void displayInventoryFull(World world)
    {
        if (InventoryFullDialogue.hasDisplayed() == false)
        {            
            world.addObject(new InventoryFullDialogue(), world.getWidth()/2, world.getHeight()/2);
        }
    }
    public void addedToWorld(World World)
    {
        getImage().setTransparency(0);
        getImage().scale(1280,720);
    }
    public void toggleInventory()
    {
        if(!inventoryShowing)
        {
            getImage().setTransparency(255);
            for (int i = 0; i < Global.collectedObjects.size(); i++)
            {
                Actor item = Global.collectedObjects.get(i);
                GreenfootImage itemImage = new GreenfootImage(item.getImage());
                itemImage.scale(60, 60);
                item.setImage(itemImage);
                int xItem = INVENTORY_COORDINATES[i][0];
                int y = INVENTORY_COORDINATES[i][1];
                getWorld().addObject(item, xItem, y);
                inventoryObjects.add(item);
            }
            inventoryShowing = true;
        }
        else
        { 
            if(toBeRemoved.size()>0){
                for(int i=0; i<toBeRemoved.size(); i++){
                    remove(toBeRemoved.get(i));
                }
                toBeRemoved = new ArrayList <Actor>();
            }
            getImage().setTransparency(0);
            getWorld().removeObjects(inventoryObjects);
            inventoryShowing = false;
        }
    }
    public void removeInv()
    {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int indexX = mouse.getX();
            int indexY = mouse.getY();
            for(int i=0; i<30; i++){
                if(indexX>=INVENTORY_COORDINATES[i][0]-15  && indexX<=INVENTORY_COORDINATES[i][0]+15  && indexY<=INVENTORY_COORDINATES[i][1]+15  && indexY>=INVENTORY_COORDINATES[i][1]-15){
                    Global.collectedObjects.get(i).getImage().setTransparency(0);
                    toBeRemoved.add(Global.collectedObjects.get(i));
                }
            }
            todo.deletedObject = true;
    }
    public void checkInv()
    {
        if (Greenfoot.isKeyDown("i") )
        {
            toggleInventory();
            Greenfoot.delay(10);
        }
    }  
    public void remove(Actor a)
    {
        Global.collectedObjects.remove(a);
    }        
}