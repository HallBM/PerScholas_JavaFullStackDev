package testing;

public class Test5 {

	
	public static void main (String [] args) {
		//String s = "abc";
		//String j = "abc";
		//String k = new String("abc");
		
		//System.out.println(s == j);
		//System.out.println(s.equals(j));
		//System.out.println(s.hashCode() == j.hashCode());
		
		//System.out.println(s == k);
		//System.out.println(s.equals(k));
		//System.out.println(s.hashCode() == k.hashCode());
	
		try {
			Animal animal = new Animal();
			float f = animal.divide(5,0);
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println("this is the main class not the animal class");
		} finally{
			System.out.println("end");
		}
		
		main(null, 37);
		
	}

	public static void main (String[] args, int b) {
		System.out.println("second main " + b);
	}
	
	
	
	
	
	
	
	
	
	
	
}
