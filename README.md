# UBS_Retail
This project is an exercise for supermarket like setup  .

The project has basically 4 packages ,description of each component is explained explicitly below :

com.practice.demo.retail.supermarket : 
  This has two classes 
     1.SuperMarket: This class contains all the items of the super market 
     2.Item :The basic element of the super market 
       This class has below fields 
       <>Item Code: A code associated to any item .
       <>Item Price: Price of individual item of this code type .
       <>Number Of Items : Total number of items 
       <>Discount Opportunity : Yes/No
       <>If Discount then what percent for individual item 
       <>Number of Items required for discount at minimum 

com.practice.demo.retail.feed : 
  This package has below classes which are a form of implementation for their interfaces 
     1.CheckInImpl :This class reads an item code and populates all its attributes and returns
                    the item to the client which in turn puts the item to the supermarket.
     2.CheckoutImpl :This class is used to checkout individual items with a particular item code
                     and its price also used for checking out all the items of the store also used
                     for showing the whole catalog of the store to the client
 
 com.practice.demo.retail.bill : 
 This package has below classes 
     1.BillCalculatorImpl : This class contains the logic to calculate the items price individually as well as collectively .
     
     Basically to calculate the individual price of an item type , it takes in to consideration the price of the item code 
     the number of items for which the price is to be calculated then if there is discount availed during the time of checkin
     if yes then checks if the number of items checked out are greater than or equivalent to number required for discount 
     if yes then uses the discount amount to calculate the price of items of a particular type or code or else it uses the 
     original price to calculate the price 
     
     For example : 
     
     Item cd	Item price	Total number of items 	Discount offer 	Minimum items reqd for discount 	Discount amount in percentage 
       A	      10	            4	                    Yes 	             3 	                                  40

    For the above data when the user checks out say 3 items which is minimum for discount price it 
    checks the discount for individual item which is 40% and which would equal to be price of 6 units for each in 3 items
    the sum would come up to be 3*6=18 .
    
    If the items were to be 2 which is lesser than the minimum required number for discount the actual price would be used and 
    the amount for checking out 2 items would turn out to be 2*10=20 . 
    
    When calculating the price collectively for all the items , the algorithm or the logic looks at the item if it has discount then
    uses the discount amount as a whole and applies that to all the items 
    
    For example :
    
    for the item code A , the total amount with out discount turns out to be 40 but since this item has the option of discount
    it uses discount amount for all 4 items and produces the result 4*6=24 as the sum for all the 4 items of A .
    This logic is used for all the items cumulatively in the store to arrive at the final cumulative sum of the whole store .

     
    com.practice.demo.retail.exception  : 
     
     This package is used to catch the application specific exceptions 
          1. ItemNotFoundException :       When the client is trying to check out an item which does not exist yet in the store 
          2. InvalidNumberofItemsException:When the discount number of items exceeds the total number of items of a particualr type 
                                           also when the number of items to be checked out exceeds the total number of items of that                                                type .
          3. InvalidDiscountException:     When the discount amount goes out of range from 1 to 100 
 
       
  
Then there are basically 3 clients to test this functionality :

1. Standalone client class: com.assignment.ubs.standalone.supermarket.SuperMarketClient
   its a standard java class with main method and can be easily used to test the functionality with out even looking at any testing 
   frame work.

2. Junit client class : com.assignment.ubs.junit.supermarket.SuperMarketClient
   Its a junit test class and has 4 test cases
   1.checkinItems : to check in the items to the store 
   2.singleItemCheckout : to check out a individual item type 
   3.showCatalogOfItems : to display all the items in the supermarket which have been checked in with their collective price inclusive 
                          of discount 
   4.sumofItemsCheckout : to calculate the sum of all the items of the store inclusive of discount amount if they have any 

3. TestNG client class : com.assignment.ubs.testng.supermarket
   There is testng.xml file which is configured to run with this project while doing maven build 
   By running the below maven build command 
   
   mvn clean install 
   
   All the test cases would run synchronously if it needs to be run individually then can run the commands like below 
   
   
   mvn -Dtest=com.assignment.ubs.testng.supermarket.SuperMarketClient#checkinItems test
   
   mvn -Dtest=com.assignment.ubs.testng.supermarket.SuperMarketClient#singleItemCheckout test
   
   mvn -Dtest=com.assignment.ubs.testng.supermarket.SuperMarketClient#showCatalogOfItems test
   
   mvn -Dtest=com.assignment.ubs.testng.supermarket.SuperMarketClient#allItemsCheckout test
   
   
   I have attached a Junit test cases or functional test scenarios document with this project can look for the reference to run the    
   project in an IDE environment . The name of the document is Functional Test Cases_Super Market.docx  .
   
   I have also attached a highlevel sequence diagram indicating the flow of calls between different componets of the application
   the name of that document is UBS_Retail_Demo_Sequence.pdf .
   
