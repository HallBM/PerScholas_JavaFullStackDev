package testing;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class Test {

	public enum MyDatabaseconnection {
		   ORACLEDB("ORACLE DATABASE IS CONNECTION ..."),
		   SQLDBB("SQL DATABASE IS CONNECTING..."),
		   POSTGRESSQL("POSTGRES DATABASE IS CONNECTING"),
		   ABC("1234........5");
		  // Class variable  
		   private final String establishDatabaseConnection;
		   // private enum constructor
		   private MyDatabaseconnection(String establishDatabaseConnection) {
		       this.establishDatabaseConnection = establishDatabaseConnection;
		   }
		   // getter
		   public String getEstablishDatabaseConnection() {
		       return establishDatabaseConnection;   }
		}


	 	    public static void main(String[] args)
	    {
	 
	        // Integer List
	        List<Integer> list1 = Arrays.asList(1, 2, 3)  ;
	 
	        // Double list
	        List<Double> list2 = Arrays.asList(1.1, 2.2, 3.3);
	 
	        
	        printlist(list1);
	 
	        printlist(list2);
	        
	        
	        MyDatabaseconnection db = MyDatabaseconnection.ABC;
	        System.out.println(db);
	        System.out.println(db.getEstablishDatabaseConnection());

	    }
	 
	    private static void printlist(List<?> list)
	    {
	 
	        System.out.println(list);
	    }
	    

	    

	}
