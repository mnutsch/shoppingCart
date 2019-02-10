
/**************************************************************************************************************************
* Shopping Cart
* by Matt Nutsch
* 2-9-2019
* Test at https://www.compilejava.net/
**************************************************************************************************************************/

import java.lang.Math; 
import java.text.DecimalFormat; //For controlling the format of prices.

public class ShoppingCart{
  // arguments are passed using the text field below this editor
  public static void main(String[] args){
    
    Product[] theProducts = new Product[4]; //Initialize the item type array.
    double total = 0; //Intitialize the total at $0.00
    DecimalFormat df2 = new DecimalFormat("0.00"); //For displaying in 2 decimal places.
    
    theProducts[0] = new Product("Apple");
    theProducts[0].setPrice(0.25);
    theProducts[1] = new Product("Orange");
    theProducts[1].setPrice(0.30);
    theProducts[2] = new Product("Banana");
	theProducts[2].setPrice(0.15);
    theProducts[3] = new Product("Papaya");
	theProducts[3].setPrice(0.50);
    theProducts[3].setThreeForTwoSpecial(true);
	
	//Open input file.
    //DEV NOTE: ADD CODE HERE
    
    //Initialize the input array
    //DEV NOTE: This array is for debugging purposes. Replace it with input read from a file.
    String[] inputLines = new String[13];
    inputLines[0] = "Apple";
    inputLines[1] = "Papaya";
    inputLines[2] = "Apple";
    inputLines[3] = "Banana";
    inputLines[4] = "Banana";
    inputLines[5] = "Orange";
    inputLines[6] = "Papaya";
    inputLines[7] = "Banana";
    inputLines[8] = "Apple";
    inputLines[9] = "Orange";
    inputLines[10] = "Orange";
    inputLines[11] = "Papaya";
    inputLines[12] = "Apple";

	//For each line in input file.
    for(int i = 0; i < inputLines.length; i++){
      
      //Increment the quantity of the appropriate item type.
      for(int j = 0; j < theProducts.length; j++)
      {
        if(inputLines[i] == theProducts[j].getName())
        {
          int currentQuantity = theProducts[j].getQuantity();
          int newQuantity = currentQuantity + 1;
          theProducts[j].setQuantity(newQuantity);
        }
      }
      
    }

	//For each item type: 	
    for(int i = 0; i < theProducts.length; i++){
      
	    //Calculate the subtotal
      	double subtotal = 0;
      	subtotal = theProducts[i].getQuantity() * theProducts[i].getPrice();
      
		//Calculate any discounts (papaya are 3 for the price of 2)
      	if(theProducts[i].getThreeForTwoSpecial() == true)
        {
          int quotient = theProducts[i].getQuantity() / 3;
          subtotal = subtotal - (quotient * theProducts[i].getPrice());
        }

      	subtotal = Math.round(subtotal*100.0)/100.0;
      
        theProducts[i].setSubtotal(subtotal);

		//Add the subtotal to the total
      	total = total + subtotal;
    }

	//Open output file
    //DEV NOTE: ADD CODE HERE

	//For each item type
    for(int i = 0; i < theProducts.length; i++){
		//Output item data to file: "Apple: $1.00"
      	//DEV NOTE: ADD CODE HERE  	
      	System.out.println(theProducts[i].getName() + ": $" + df2.format(theProducts[i].getSubtotal()));
    }

	//Output total to file: "Total: $3.35"
    //DEV NOTE: ADD CODE HERE
    System.out.println("Total: $" + df2.format(total));
  }
}

// you can add other public classes to this editor in any order
public class Product{
  private String name;
  private double price = 0.0;
  private int quantity = 0;
  private boolean threeForTwoSpecial = false;
  private double subtotal = 0.0;
  
  public Product(String input){
    name = input;
  }
  
  public String toString(){
    return name;
  }
  
  public double getPrice(){
    return price; 
  }
  
  public String getName(){
   	return name; 
  }
  
  public int getQuantity(){
   	return quantity; 
  }
  
  public double getSubtotal(){
    return subtotal; 
  }
  
  public boolean getThreeForTwoSpecial(){
   	return threeForTwoSpecial;
  }
  
  public boolean setPrice(double newPrice){
    price = newPrice;
    return true;      
  }
  
  public boolean setName(String newName){
   	name = newName;
    return true;
  }
  
  public boolean setQuantity(int newQuantity){
   	quantity = newQuantity;
    return true;
  }
  
  public boolean setSubtotal(double newSubtotal){
    subtotal = newSubtotal;
    return true;
  }
  
  public boolean setThreeForTwoSpecial(boolean newSetting){
    threeForTwoSpecial = newSetting;
    return true;
  }
  
}
