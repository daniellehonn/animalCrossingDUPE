import greenfoot.*;
import java.lang.*;
public class Trunk extends Actor
{    
    private Fruit fruits[] = new Fruit[3];
    private boolean fruitsDropped = false;
    Fruit fruit = null;
    
    public void addFruits()
    {
        int randomNum = (int)(Math.random() * 4);      
        for (int i = 0; i < fruits.length; i++)
        {
             if (randomNum == 0)
                fruit = new Apple();
             else if (randomNum == 1)
                fruit = new Orange();
             else if (randomNum == 2)
                fruit = new Cherry();
             else if (randomNum == 3)
                fruit = new Peach();
             fruits[i] = fruit;            
        }
        getWorld().addObject(fruits[0], getX()+15, getY()-155);
        getWorld().addObject(fruits[1], getX()-77, getY()-40);
        getWorld().addObject(fruits[2], getX()+98, getY()-40);
    }
    public void addedToWorld(World world)
    {
        Tree tree = new Tree();
        world.addObject(tree, this.getX(), this.getY());
        addFruits();
    }
    public void dropFruits()
    {
        if (fruitsDropped)
        {
            return;
        }
        int bottom = getY() + 230;
        for (int i = 0; i < fruits.length; i++)
        {
            if (fruits[i].isOnTree())
            {
                fruits[i].dropFruit(bottom);
            }           
        }
        fruitsDropped = true;
    }
    public void act() 
    {
         
    }    
}
