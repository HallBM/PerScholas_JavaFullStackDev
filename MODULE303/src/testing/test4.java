package testing;

import java.util.*;

interface DataType<T>{
 void addition(T a, T b);
 void subtraction(T a, T b);
 void multiplication(T a, T b);
 void division(T a, T b);	
}

/*
Write the implementation of the NumericDataType and StringDataType generic classes.
*/

class StringDataType<T> implements DataType<T>{
    public void addition(T a, T b){
        System.out.println("Adding two strings");
        System.out.println("The result is: " + a+b);
    }
    
    public void subtraction(T a, T b){
        System.out.println("Can't perform this operation on strings");
    }
    
    public void multiplication(T a, T b){
        System.out.println("Can't perform this operation on strings");
    }
    
    public void division(T a, T b){
        System.out.println("Can't perform this operation on strings");
    }
    
    public void performAll(T a, T b){
        addition(a, b);
        subtraction(a,b);
        multiplication(a, b);
        division(a, b);
    } 
}

class NumericDataType<T> implements DataType<T>{
    public void addition(T a, T b){
        System.out.println("Adding two generic instances");
        System.out.println("The result is: " + (a+b));
    }
    
    public void subtraction(T a, T b){
        System.out.println("Subtracting two generic instances");
        //System.out.printf("The result is: %.2f", (a-b));
    }
    
    public void multiplication(T a, T b){
        System.out.println("Multiplying two generic instances");
        //System.out.printf("The result is: %.2f", (a*b));
    }
    
    public void division(T a, T b){
        System.out.println("Dividing two generic instances");
        //System.out.printf("The result is: %.2f", (a/b));
    }
    
    void performAll(T a, T b){
        addition(a, b);
        subtraction(a,b);
        multiplication(a, b);
        division(a, b);
    } 
}

class test4{}
