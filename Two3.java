import greenfoot.*;
public class Two3 extends Land
{
    private Inventory inv = new Inventory();
    private Menu menu = new Menu();
    private Todo todo =  new  Todo();
    public Two3(You villager){
        super(1280, 720, 1);
        start();
        addObject(inv, getWidth() / 2, getHeight() / 2 );
        addObject(menu, getWidth() / 2, getHeight() / 2 );
        addObject(todo, getWidth() / 2, getHeight() / 2 );
        addObject(villager, 640, 480);
        setPaintOrder(Menu.class, Todo.class, Fruit.class, Shell.class, Flower.class, Inventory.class, Tree.class, You.class, FlowerStems.class, Trunk.class);
    }
    public Two3(You villager, String from)
    {    
        super(villager, from); 
    }
    public void start()
    {
        menu.getImage().setTransparency(255);
        setPaintOrder(Menu.class, You.class);
    }
}