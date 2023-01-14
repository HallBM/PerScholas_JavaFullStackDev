package testing;

class Animal{
    protected String name;
    protected int age;
    

    public Animal(String name, int age){
       this.name = name;
       this.age = age;
    }
    public Animal() {
    	
    }
    
    public void animalInfo() {
       System.out.println("Animal class info: ");
       System.out.println("Name: " + this.name);
       System.out.println("Age: " + this.age);
    }
    
    
    public static void speak() 
    	{System.out.println("ANIMAL NOISES");}
 }
