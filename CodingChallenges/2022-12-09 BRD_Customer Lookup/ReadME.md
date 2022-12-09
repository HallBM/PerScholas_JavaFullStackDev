## Business Requirements Document for assignment:
http://web.cse.ohio-state.edu/~bair.41/616/Project/Example_Document/Req_Doc_Example.html

We will focus on this functionality: 
Place Order (Customer)

Use Case Name:	
Place Order

Scenario: 
Customer places his own order.

Summary:	
This use case allows a registered customer to place an order for a product.

## Basic Flow:	
The use case start when a customer indicates he wants to place an order for the current product being displayed.
The system displays the customer's information: name, street, city, zip, phone, email.

loadVendorData() method as a starting point.

Here are the fields required for a Customer Object:

"first_name",
"last_name",
"company_name",
"address",
"city",
"county",
"state",
"zip",
"phone1",
"phone2",
"email",
"web"

Our requirements are:
1.Create  Customer objects, populate them  and utilize one of the
  Java collection class data structures ( ArrayList or LinkedList for example) to
  hold the Customer objects then 
  provide a simple lookup (use Scanner obj) as stated in this part of the BRD,
  that will take a Last_name as input.

Place Order (Customer)
2.The system displays the customer's information: name, street, city, zip, phone, email.
  given input will be last_name.

## Started code provided:
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class miniHackathon {
    public static void main(String[] args) {
    	miniHackathon m = new miniHackathon();
    	m.loadVendorData();
    }
   
    void loadVendorData()
    {	
       // please map this file to your drive
       String file = "/home/lou1/Downloads/us-500.csv";
       String line;
       try (BufferedReader br =
            new BufferedReader(new FileReader(file))) {
            while((line = br.readLine()) != null){
            	System.out.println(line);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
