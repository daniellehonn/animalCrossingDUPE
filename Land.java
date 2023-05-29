import greenfoot.*;

public class Land extends World
{
    Trunk trunk = null;
    FlowerStems stems = null;
    private Inventory inv = new Inventory();
    private Menu menu = new Menu();
    private  Todo todo = new Todo();
    public Land(int w, int h, int c)
    {    
        super(w, h, c);
        setPaintOrder(Menu.class, Todo.class, Fruit.class, Shell.class, Flower.class, Inventory.class, Tree.class, You.class, FlowerStems.class, Trunk.class);
    }
    public Land(You villager, String from)
    {
        super(1280, 720, 1);         
        if (from.equals( "right" ))
            addObject(villager, getWidth()-1, villager.getY());
        else if (from.equals( "left" ))
            addObject(villager, 0, villager.getY());
        else if (from.equals( "top" ))
            addObject(villager, villager.getX(), 0);
        else  if (from.equals( "bottom" ))
            addObject(villager, villager.getX(), getHeight()-1);
        prepare();
        setPaintOrder(GameOver.class, InventoryFullDialogue.class, Menu.class, Todo.class, Fruit.class, Shell.class, Flower.class, Inventory.class, Tree.class, You.class, FlowerStems.class, Trunk.class);
    }
    public void addFlowers()
    {              
        for (int i = 0; i < 3; i++)
        {
            int randomNum = (int)(Math.random() * 3); 
            if (randomNum == 0)
                stems = new PinkMumPlant();
             else if (randomNum == 1)
                stems = new WhiteMumPlant();
             else if (randomNum == 2)
                stems = new YellowMumPlant(); 
             addObject(stems, getRandX(), getRandY());
        }       
    }
    public void addTrees(){
        trunk = new Trunk();
        addObject(trunk, (int)(Math.random() * 880)+200, (int)(Math.random() * 218)+251);
    }
    public int getRandX()
    {
        return (int)((Math.random() * 1280));
    }
    public int getRandY()
    {
        return (int)((Math.random() * 720));
    }
    public void prepare()
    {
        addFlowers();
        addTrees();
        addObject(inv, getWidth() / 2, getHeight() / 2 );
        menu.getImage().setTransparency(0);
        addObject(menu, getWidth() / 2, getHeight() / 2 );
        todo.getImage().setTransparency(0);
        addObject(todo, getWidth() / 2, getHeight() / 2 );
    }
}
