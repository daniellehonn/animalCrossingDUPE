import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class Global extends World
{
    public static ArrayList <Actor> collectedObjects = new ArrayList <Actor>();
    /*public static final GreenfootSound  
        opening = new GreenfootSound("opening.mp3"),
        bgm = new GreenfootSound("bgm.mp3"),
        beach = new GreenfootSound("beach.mp3");*/
    
    public Global()
    {    
        super(1280, 720, 1); 
    }
}
