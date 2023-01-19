package testing;

public class Dog extends Animal implements Cloneable{
    private String color;
    
    public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Dog(String name, int age, String color){
       super(name, age);
       this.color = color;
    }
    public Dog() {

    }
    
    public void display() {
    	
    }
    
    public void dogInfo() {
       System.out.println("Dog class: ");
       System.out.println("Name: " + this.name);
       System.out.println("Age: " + this.age);
       System.out.println("Color: " + this.color);
    }
    
    
    public static void speak() {System.out.println("BARK");}
    
    
    
    
    @Override
	public String toString() {
		return this.getName() + this.getAge() + this.getColor();
	}
    
    
	public static void main(String[] args) throws CloneNotSupportedException{
       //Animal animal = new Dog("Leo", 2, "Black");
       //Dog dog = (Dog) animal; //implicit casting Object of student to person
       //dog.animalInfo();
       //dog.dogInfo();
      
    	Dog dog1 = new Dog("Leo",2,"Black");
    	Dog dog2 = (Dog) dog1.clone();
    	dog2.setName("Francis");
    	dog2.setColor("Brown");
    	    	
    	System.out.println(dog1);
    	System.out.println(dog2);
    	
       
    }
 }
