package arraydemo;

import java.util.Arrays;

import testing.Dog;

public class ResizeArray {

	public static void main(String[] args) {
		
		int number_of_elements_to_add = 5;
		
		Dog d1 = new Dog();
		Dog d2 = new Dog();
		Dog d3 = new Dog();
		Dog d4 = new Dog();
		
		Dog [] list = new Dog[] {d1, d2, d3, d4};
		list = Arrays.copyOf(list, list.length + number_of_elements_to_add);
		System.out.println(Arrays.toString(list));
		
		int [] int_list = {1,2,3,4,5,6,7,8,9,10};
				
		System.out.println(Arrays.toString(int_list));
		
	    int_list = Arrays.copyOf(int_list, int_list.length + number_of_elements_to_add);
		
		System.out.println(Arrays.toString(int_list));
		//System.out.println(Arrays.toString(new_int_list));
		//System.out.println(Arrays.equals(int_list, Arrays.copyOfRange(new_int_list, 0, int_list.length)));
		
		}

	
	
	
	
	
}
