import greenfoot.*;  
public class Menu extends Actor
{
    public void act()
    {
        checkMenu();
    }
    public void checkMenu(){
        if(Greenfoot.isKeyDown("m")){
            getImage().setTransparency(255);
            Greenfoot.delay(10);
        }
        if(Greenfoot.isKeyDown("e")){
            getImage().setTransparency(0);
            Greenfoot.delay(10);
        }
    }
}
