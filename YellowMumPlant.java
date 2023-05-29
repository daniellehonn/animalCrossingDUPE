import greenfoot.*;  
public class YellowMumPlant extends FlowerStems
{
    private boolean plucked = false;
    private GreenfootSound pluck = new GreenfootSound("pluck.mp3");
    public YellowMumPlant()
    {
        GreenfootImage image = getImage();
    }
    public void act()
    {
        if(!plucked && Greenfoot.isKeyDown("p") && isTouching(You.class)){
            pluck();
            Greenfoot.delay(10);
        }
    }
    public void pluck(){
        pluck.play();
        Greenfoot.delay(1);
        setImage("plucked_plant.png");
        getWorld().addObject(new YellowMum(), getX()-35, getY()+35);
        plucked = true;
    }
}
