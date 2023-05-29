import greenfoot.*; 

public class You extends AnimalCrossingCharacter
{
    final static int DISTANCE = 4;
    final static int START = 0;
    public Todo todo = new Todo();
    public GameOver go =  new GameOver();
    public GreenfootSound bgm = new GreenfootSound("bgm.mp3");
    private GreenfootSound beach = new GreenfootSound("beach.mp3");
    
    public You(){
        villagerRight =  new GreenfootImage[6];
        villagerLeft = new GreenfootImage[6];
        villagerUp = new GreenfootImage[6];
        villagerDown = new GreenfootImage[6];
        
        imageLeft = new GreenfootImage("idleLeft.png");
        imageRight = new GreenfootImage("idleRight.png");
        imageUp = new GreenfootImage("idleUp.png");
        imageDown = new GreenfootImage("idleDown.png");
         
        imageLeft.scale(75, 140);
        imageRight.scale(75, 140);
        imageUp.scale(85, 140);
        imageDown.scale(85, 140);
        
        GreenfootImage image = null;
        setImage(imageRight);
        for(int i = 1; i <= villagerRight.length; i++){
            image = new GreenfootImage("right_animation_" + i + ".png"); 
            image.scale(80, 140);
            villagerRight[i-1] = image;
        }
        for(int i = 1; i <= villagerLeft.length; i++){
            image = new GreenfootImage("left_animation_" + i + ".png"); 
            image.scale(80, 140);
            villagerLeft[i-1] = image;
        }
        for(int i = 1; i <= villagerUp.length; i++){
            image = new GreenfootImage("up_animation_" + i + ".png"); 
            image.scale(85, 140);
            villagerUp[i-1] = image;
        }
        for(int i = 1; i <= villagerDown.length; i++){
            image = new GreenfootImage("down_animation_" + i + ".png"); 
            image.scale(85, 140);
            villagerDown[i-1] = image;
        }
    }
    
    public void act()
    {
        status = checkKeys();
        checkPosition();
        playBGM();
        beachBGM();
    }
    
    public void checkPosition(){
        String worldType = getWorld().getClass().getName();
        
        if (worldType.equals("One1")){
            if(getX() >= getWorld().getWidth()-1){
                Greenfoot.setWorld(new One2(this, "left"));
            }
            else if(getY() >= getWorld().getHeight()-1){
                Greenfoot.setWorld(new Two1(this, "top"));
            }
            if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell11 = true;
                        }
                    }
                }
        }
        else if (worldType.equals("One2")){
            if(getX() >= getWorld().getWidth()-1){
                Greenfoot.setWorld(new One3(this, "left"));
            }
            else if(getX() == 0){
                Greenfoot.setWorld(new One1(this, "right"));
            }
            else if(getY() >= getWorld().getHeight()-1){
                Greenfoot.setWorld(new Two2(this, "top"));
            }
            
            if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell12 = true;
                        }
                    }
                }
        }
        else if (worldType.equals("One3")){
            if(getX() >= getWorld().getWidth()-1){
                Greenfoot.setWorld(new One4(this, "left"));
            }
            else if(getX() == 0){
                Greenfoot.setWorld(new One2(this, "right"));
            }
            else if(getY() >= getWorld().getHeight()-1){
                Greenfoot.setWorld(new Two3(this, "top"));
            }
            
            if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell13 = true;
                        }
                    }
                }
        }
        else if (worldType.equals("One4")){
            if(getX() == 0){
                Greenfoot.setWorld(new One3(this, "right"));
            }
            else if(getY() >= getWorld().getHeight()-1){
                Greenfoot.setWorld(new Two4(this, "top"));
            }
            
            if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell14 = true;
                        }
                    }
                }
        }
        
        else if (worldType.equals("Two1")){
            if(getX() >= getWorld().getWidth()-1){
                Greenfoot.setWorld(new Two2(this, "left"));
            }
            else if(getY() >= getWorld().getHeight()-1){
                Greenfoot.setWorld(new Three1(this, "top"));
            }
            else if(getY() == 0){
                Greenfoot.setWorld(new One1(this, "bottom"));
            }
            
            if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell21 = true;
                        }
                    }
                }
        }
        else if (worldType.equals("Two2")){
            if(getX() >= getWorld().getWidth()-1){
                Greenfoot.setWorld(new Two3(this, "left"));
            }
            else if(getX() == 0){
                Greenfoot.setWorld(new Two1(this, "right"));
            }
            else if(getY() >= getWorld().getHeight()-1){
                Greenfoot.setWorld(new Three2(this, "top"));
            }
            else if(getY() == 0){
                Greenfoot.setWorld(new One2(this, "bottom"));
            }
            
            if (isTouching(Flower.class))
            {
                Flower flower = (Flower)getOneIntersectingObject(Flower.class);
                if (flower.isInInventory() == false)
                {                    
                    boolean isFull = Inventory.addToInventory(flower);
                    if (isFull)
                    {
                        Inventory.displayInventoryFull(getWorld());
                    }
                    else
                    {
                        flower.setInInventoryState();
                        getWorld().removeObject(flower);
                        todo.flower22 = true;
                    }
                }
            }
            if (isTouching(Trunk.class) && Greenfoot.isKeyDown("h")){
                    Trunk trunk = (Trunk)getOneIntersectingObject(Trunk.class);
                    trunk.dropFruits();                
                }
                if (isTouching(Fruit.class)){
                    Fruit fruit = (Fruit)getOneIntersectingObject(Fruit.class);
                    if (fruit.isDropped()){                                                            
                        boolean isFull = Inventory.addToInventory(fruit);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            fruit.setInInventoryState();
                            getWorld().removeObject(fruit);
                            todo.fruit22 = true;
                        }   
                    }
                }
        }
        else if (worldType.equals("Two3")){
            if(getX() >= getWorld().getWidth()-1){
                Greenfoot.setWorld(new Two4(this, "left"));
            }
            else if(getX() == 0){
                Greenfoot.setWorld(new Two2(this, "right"));
            }
            else if(getY() >= getWorld().getHeight()-1){
                Greenfoot.setWorld(new Three3(this, "top"));
            }
            else if(getY() == 0){
                Greenfoot.setWorld(new One3(this, "bottom"));
            }
            
            if (isTouching(Flower.class))
            {
                Flower flower = (Flower)getOneIntersectingObject(Flower.class);
                if (flower.isInInventory() == false)
                {                    
                    boolean isFull = Inventory.addToInventory(flower);
                    if (isFull)
                    {
                        Inventory.displayInventoryFull(getWorld());
                    }
                    else
                    {
                        flower.setInInventoryState();
                        getWorld().removeObject(flower);
                        todo.flower23 = true;
                    }
                }
            }
            if (isTouching(Trunk.class) && Greenfoot.isKeyDown("h")){
                    Trunk trunk = (Trunk)getOneIntersectingObject(Trunk.class);
                    trunk.dropFruits();                
                }
                if (isTouching(Fruit.class)){
                    Fruit fruit = (Fruit)getOneIntersectingObject(Fruit.class);
                    if (fruit.isDropped()){                                                            
                        boolean isFull = Inventory.addToInventory(fruit);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            fruit.setInInventoryState();
                            getWorld().removeObject(fruit);
                            todo.fruit23 = true;
                        }   
                    }
                }
        }
        else if (worldType.equals("Two4")){
            if(getX() == 0){
                Greenfoot.setWorld(new Two3(this, "right"));
            }
            else if(getY() >= getWorld().getHeight()-1){
                Greenfoot.setWorld(new Three4(this, "top"));
            }
            else if(getY() == 0){
                Greenfoot.setWorld(new One4(this, "bottom"));
            }
            
            if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell24 = true;
                        }
                    }
                }
        }
        
        else if (worldType.equals("Three1"))
            {
                if(getX() >= getWorld().getWidth()-1)
                {
                    Greenfoot.setWorld(new Three2(this, "left"));
                }
                else if(getY() >= getWorld().getHeight()-1)
                {
                    Greenfoot.setWorld(new Four1(this, "top"));
                }
                else if(getY() == 0)
                {
                    Greenfoot.setWorld(new Two1(this, "bottom"));
                }
                
                if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell31 = true;
                        }
                    }
                }
            }
            else if (worldType.equals("Three2"))
            {
                if(getX() >= getWorld().getWidth()-1)
                {
                    Greenfoot.setWorld(new Three3(this, "left"));
                }
                else if(getX() == 0)
                {
                    Greenfoot.setWorld(new Three1(this, "right"));
                }
                else if(getY() >= getWorld().getHeight()-1)
                {
                    Greenfoot.setWorld(new Four2(this, "top"));
                }
                else if(getY() == 0)
                {
                    Greenfoot.setWorld(new Two2(this, "bottom"));
                }
                if (isTouching(Flower.class)){
                    Flower flower = (Flower)getOneIntersectingObject(Flower.class);
                    if (flower.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(flower);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            flower.setInInventoryState();
                            getWorld().removeObject(flower);
                            todo.flower32 = true;
                        }
                    }
                }
                if (isTouching(Trunk.class) && Greenfoot.isKeyDown("h")){
                    Trunk trunk = (Trunk)getOneIntersectingObject(Trunk.class);
                    trunk.dropFruits();                
                }
                if (isTouching(Fruit.class)){
                    Fruit fruit = (Fruit)getOneIntersectingObject(Fruit.class);
                    if (fruit.isDropped()){                                                            
                        boolean isFull = Inventory.addToInventory(fruit);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            fruit.setInInventoryState();
                            getWorld().removeObject(fruit);
                            todo.fruit32 = true;
                        }   
                    }
                }
            }
            else if (worldType.equals("Three3"))
            {
                if(getX() >= getWorld().getWidth()-1)
                {
                    Greenfoot.setWorld(new Three4(this, "left"));
                }
                else if(getX() == 0)
                {
                    Greenfoot.setWorld(new Three2(this, "right"));
                }
                else if(getY() >= getWorld().getHeight()-1)
                {
                    Greenfoot.setWorld(new Four3(this, "top"));
                }
                else if(getY() == 0)
                {
                    Greenfoot.setWorld(new Two3(this, "bottom"));
                }
                
                if (isTouching(Flower.class)){
                    Flower flower = (Flower)getOneIntersectingObject(Flower.class);
                    if (flower.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(flower);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            flower.setInInventoryState();
                            getWorld().removeObject(flower);
                            todo.flower33  =  true;
                        }
                    }
                }
                
                if (isTouching(Trunk.class) && Greenfoot.isKeyDown("h")){
                    Trunk trunk = (Trunk)getOneIntersectingObject(Trunk.class);
                    trunk.dropFruits();                
                }
                if (isTouching(Fruit.class)){
                    Fruit fruit = (Fruit)getOneIntersectingObject(Fruit.class);
                    if (fruit.isDropped()){                                                            
                        boolean isFull = Inventory.addToInventory(fruit);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            fruit.setInInventoryState();
                            getWorld().removeObject(fruit);
                            todo.fruit33 = true;
                        }   
                    }
                }
            }
            else if (worldType.equals("Three4"))
            {
                if(getX() == 0)
                {
                    Greenfoot.setWorld(new Three3(this, "right"));
                }
                else if(getY() >= getWorld().getHeight()-1)
                {
                    Greenfoot.setWorld(new Four4(this, "top"));
                }
                else if(getY() == 0)
                {
                    Greenfoot.setWorld(new Two4(this, "bottom"));
                }
                
                if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell34 = true;
                        }
                    }
                }
            }
            
            else if (worldType.equals("Four1"))
            {
                if(getX() >= getWorld().getWidth()-1)
                {
                    Greenfoot.setWorld(new Four2(this, "left"));
                }
                else if(getY() == 0)
                {
                    Greenfoot.setWorld(new Three1(this, "bottom"));
                }
                
                if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell41 = true;
                        }
                    }
                }
            }
            else if (worldType.equals("Four2"))
            {
                if(getX() >= getWorld().getWidth()-1)
                {
                    Greenfoot.setWorld(new Four3(this, "left"));
                }
                else if(getX() == 0)
                {
                    Greenfoot.setWorld(new Four1(this, "right"));
                }
                else if(getY() == 0)
                {
                    Greenfoot.setWorld(new Three2(this, "bottom"));
                }
                
                if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell42 = true;
                        }
                    }
                }
            }
            else if (worldType.equals("Four3"))
            {
                if(getX() >= getWorld().getWidth()-1)
                {
                    Greenfoot.setWorld(new Four4(this, "left"));
                }
                else if(getX() == 0)
                {
                    Greenfoot.setWorld(new Four2(this, "right"));
                }
                else if(getY() == 0)
                {
                    Greenfoot.setWorld(new Three3(this, "bottom"));
                }
                
                if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell43 = true;
                        }
                    }
                }
            }
            else if (worldType.equals("Four4"))
            {
                if(getX() == 0)
                {
                    Greenfoot.setWorld(new Four3(this, "right"));
                }
                else if(getY() == 0)
                {
                    Greenfoot.setWorld(new Three4(this, "bottom"));
                }
                if (isTouching(Shell.class)){
                    Shell shell = (Shell)getOneIntersectingObject(Shell.class);
                    if (shell.isInInventory() == false){                    
                        boolean isFull = Inventory.addToInventory(shell);
                        if (isFull){
                            Inventory.displayInventoryFull(getWorld());
                        }
                        else{
                            shell.setInInventoryState();
                            getWorld().removeObject(shell);
                            todo.shell44 = true;
                        }
                    }
                }
            }
        }
    public void playBGM(){
        bgm.playLoop();
    }
    
    public void beachBGM(){
        String worldType = getWorld().getClass().getName();

        if(worldType.equals("Two2") || worldType.equals("Two3") || worldType.equals("Three2") || worldType.equals("Three3")){
            beach.stop();
        }
        else
            beach.playLoop();
    }
    }    