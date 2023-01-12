## Coding challenge: 
Utilizing Maven, generate a Java program that creates and modifies entries in a\
database with implementation of JDBC API (MySQL driver)

## Specified requirements: 
1) Create Table in Database:\
Customer table: id(int), email(varchar2), fname(varchar2), lname(varchar2)\
Item table: id(int), name(varchar2), price(Number(4,2)).

2) Create models for each table.

3) Create DAOs with the following methods:\
**--CustomerDAO--**\
getCustomerById(int id) - Returns the customer object for the given id.\
addCustomer(Customer c) - Adds a customer with given information.\
removeCustomerById(int id) - Removes a customer with the given id.\
**--ItemDAO--**\
getAllItems() - Returns a list of all item objects in the database.\
addItem(Item i) - Adds an item with given information.\
removeItemById(int id) - Removes an item with the given id.

4) Create additional classes and attributes as needed.

## Additional features included as part of solution:
1) Checks if database exists, and if not, will create the database it utilizes.
2) Created method in DAO implementation classes (CustomerDAOImp and ItemDAOImpl) to create Customer and Items tables if not already present.
3) Overloaded constructor methods of model classes (Customers, Items) to allow the user to specify an id; if not, the DAO implementations will use the AUTO_INCREMENT attribute from the designed table definition).
