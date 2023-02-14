package testing;

class Animal{
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public float divide(int a, int b) {
		return (a/b);
	}

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
