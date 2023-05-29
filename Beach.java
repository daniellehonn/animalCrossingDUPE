import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Beach extends World
{
    Shell shell = null;
    private Inventory inv = new Inventory();
    private Menu menu = new Menu();
    private Todo todo = new Todo();
    private int X1;
    private int X2;
    private int Y1;
    private int Y2;
    public Beach(You villager, String from, int x1, int x2, int y1, int y2)
    {
        super(1280, 720, 1);
        X1 = x1;
        X2 = x2;
        Y1 = y1;
        Y2 = y2;
        if (from.equals( "right" ))
            addObject(villager, getWidth()-1, villager.getY());
        else if (from.equals( "left" ))
            addObject(villager, 0, villager.getY());
        else if (from.equals( "top" ))
            addObject(villager, villager.getX(), 0);
        else  if (from.equals( "bottom" ))
            addObject(villager, villager.getX(), getHeight()-1);
        prepare();
    }
    public Beach(You villager, String from)
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
    }
    public void addShells()
    {              
        for (int i = 0; i < (int)(Math.random() * 8)+1; i++)
        {
            int randomNum = (int)(Math.random() * 2); 
            if (randomNum == 0)
                shell = new Conch();
             else if (randomNum == 1)
                shell = new Coral();
             addObject(shell, (int)(Math.random()*X2-X1)+X1, (int)(Math.random()*Y1-Y2)+Y2);
        }       
    }
    public void prepare()
    {
        addShells();
        addObject(inv, getWidth() / 2, getHeight() / 2 );
        menu.getImage().setTransparency(0);
        addObject(menu, getWidth() / 2, getHeight() / 2 );
        todo.getImage().setTransparency(0);
        addObject(todo, getWidth() / 2, getHeight() / 2 );
    }
}
