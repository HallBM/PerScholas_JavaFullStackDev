package unit1;

public class Dog extends Animal {
    public String color;
    public Dog(String name, int age, String color){
       super(name, age);
       this.color = color;
    }
    public void dogInfo() {
       System.out.println("Dog class: ");
       System.out.println("Name: " + this.name);
       System.out.println("Age: " + this.age);
       System.out.println("Color: " + this.color);
    }
    public static void main(String[] args) {
     Animal animal = new Dog("Leo", 2, "Black");
       Dog dog = (Dog) animal; //implicit casting Object of student to person
       dog.animalInfo();
       dog.dogInfo();
    }
 }
