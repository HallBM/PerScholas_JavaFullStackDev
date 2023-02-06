package testing;

public class Test5 {

	
	public static void main (String [] args) {
		String s = "abc";
		String j = "abc";
		String k = new String("abc");
		
		System.out.println(s == j);
		System.out.println(s.equals(j));
		System.out.println(s.hashCode() == j.hashCode());
		
		System.out.println(s == k);
		System.out.println(s.equals(k));
		System.out.println(s.hashCode() == k.hashCode());
		
	}
	
	
}
