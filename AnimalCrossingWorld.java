import greenfoot.*;
public class AnimalCrossingWorld extends World
{
    public static Inventory inv = new Inventory();
    public  static Menu menu = new Menu();
    public GreenfootSound bg = new GreenfootSound("opening.mp3");
    public AnimalCrossingWorld()
    {
        super(1280, 720, 1);
        addObject(inv, getWidth() / 2, getHeight() / 2 );
        act();

    }
    public void act(){
        bg.play();
        You villager = new You();
        checkKeys(villager);
    }
    private void checkKeys(You v){
        if(Greenfoot.isKeyDown("enter")){
            bg.stop();
            Greenfoot.setWorld(new Two3(v));
        }
    }
}
