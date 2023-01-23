package treesetdemo;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetEx5 implements Comparator<String>{
   public static void main(String[] args) {
       // Create a TreeSet with user-defined comparator
       TreeSet<String> cities = new TreeSet<>();
       //add elements to the comparator
       cities.add("UAE");
       cities.add("Mumbai");
       cities.add("NewYork");
       cities.add("Hyderabad");
       cities.add("Karachi");
       cities.add("Xanadu");
       cities.add("Lahore");
       cities.add("Zagazig");
       cities.add("Yingkou");

       //print the contents of TreeSet
       System.out.println("TreeSet: " + cities);
   }
	@Override
	public int compare(String a, String b) {
		int value = a.compareTo(b);
		// sort elements in reverse order
		if (value > 0) {
			return -1;
		} else if (value < 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
