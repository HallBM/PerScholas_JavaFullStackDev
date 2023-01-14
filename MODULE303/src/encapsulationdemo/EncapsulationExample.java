package encapsulationdemo;

public class EncapsulationExample {
   public static void main(String[] args) {
       HumanBeing h1 = new HumanBeing();
       // using setters of HumanBeing
       h1.setHeight(1.65f);
       h1.setWeight(68);
       h1.setBmi(calculateBmi(h1));

       // using getters of HumanBeing
       System.out.println("Person has "+h1.getWeight()+" kgs and is "+h1.getHeight()+" meters in height, which results in BMI of "+h1.getBmi());
   
       // created new constructor class to take in weight and height only
       // added calculateBmi to HumanBeing class to determine it's own BMI
       // test code as HumanBeing h2
       
       HumanBeing h2 = new HumanBeing(90f, 1.75f); 
       System.out.println("Person has "+h2.getWeight()+" kgs and is "+h2.getHeight()+" meters in height, which results in BMI of "+h2.getBmi());

   }

   public static float calculateBmi(HumanBeing h1){
	   return h1.getWeight()/(h1.getHeight()*h1.getHeight());
   }
}
