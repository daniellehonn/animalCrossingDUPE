import greenfoot.*;
import java.util.*;
public class AnimalCrossingCharacter extends Actor
{
    final static int DISTANCE = 4;
    
    final static int LEFT = 1;
    final static int RIGHT = 2;
    final static int UP = 3;
    final static int DOWN = 4;
    
    final static int RIGHT_SCREEN = 1;
    int walkIndex = 0;
    float walkValue = 0;
    
    protected GreenfootImage[] villagerRight;
    protected GreenfootImage[] villagerLeft;
    protected GreenfootImage[] villagerUp;
    protected GreenfootImage[] villagerDown;
    
    protected GreenfootImage imageLeft;
    protected GreenfootImage imageRight;
    protected GreenfootImage imageUp;
    protected GreenfootImage imageDown;
    int direction = 0;
    int status = 0;

    public void act() 
    {
        
    }    
    public int checkKeys()
    {               
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            if (walkIndex >= villagerLeft.length)
            {
                walkValue = 0; 
                walkIndex = 0;
            }
            setImage(villagerLeft[walkIndex]);
            walkValue += 0.25;  
            walkIndex = (int) walkValue;
            
            setLocation(getX()-DISTANCE, getY());
            direction = LEFT;
        }
        else if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {            
            if (walkIndex >= villagerRight.length)
            {
                walkValue = 0; 
                walkIndex = 0;
            }
            setImage(villagerRight[walkIndex]);
            walkValue += 0.25;  
            walkIndex = (int)walkValue;
            
            int newX = getX()+DISTANCE;
            setLocation(newX, getY());
            if (newX >= 749)
            {
                status = RIGHT_SCREEN;
            }
            direction = RIGHT;           
        }
        else if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
        {
            if (walkIndex >= villagerUp.length)
            {
                walkValue = 0; 
                walkIndex = 0;
            }
            setImage(villagerUp[walkIndex]);
            
            walkValue += 0.33;  
            walkIndex = (int) walkValue;
            
            setLocation(getX(), getY()-DISTANCE);
            direction = UP;           
        }
        else if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
        {
            if (walkIndex >= villagerDown.length)
            {
                walkValue = 0; 
                walkIndex = 0;
            }
            setImage(villagerDown[walkIndex]);
            walkValue += 0.15;  
            walkIndex = (int) walkValue;
            
            setLocation(getX(), getY()+DISTANCE);
            direction = DOWN;           
        }
        else
        {
            if (direction == LEFT)            
                setImage(imageLeft);
            else if (direction == RIGHT)
                setImage(imageRight);
            else if (direction == UP)
                setImage(imageUp);
            else if (direction == DOWN)
                setImage(imageDown);
        }
        return status;        
    }}
