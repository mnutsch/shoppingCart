
/**************************************************************************************************************************
* Name: Shopping Cart
* Description: This file contains the main code for performing shopping cart calculations.
**************************************************************************************************************************/

import java.lang.Math; //For performing mathematical operations.
import java.text.DecimalFormat; //For controlling the format of prices.
import java.io.*; //For writing to a file.
import java.util.Date; //For formatting a timestamp.
import java.text.SimpleDateFormat; //For getting a timestamp.

public class ShoppingCart{
  // arguments are passed using the text field below this editor
  public static void main(String[] args) throws IOException {

    Product[] theProducts = new Product[4]; //Initialize the item type array.
    double total = 0; //Intitialize the total at $0.00
    DecimalFormat df2 = new DecimalFormat("0.00"); //For displaying in 2 decimal places.
    String inputFileName = ""; //The input file name.
    String outputFileName = ""; //The output file name.
    ReadFile rf = new ReadFile(); //For reading a file.
    String[] inputLines; //For use in reading input file.

    //Read the command line arguments.
    if(args.length == 0){
      System.out.println("No arguments received.");
      System.out.println("The first argument should be the input file name.");
      System.out.println("If provided, a second argument will be the output file name.");
      System.out.println("For example: ShoppingCart input.txt output.txt");
      return;
    }
    if(args.length >= 1){
      inputFileName = args[0];
      String timeStamp = new SimpleDateFormat("_yyyy-MM-dd-HH-mm-ss").format(new Date());
      outputFileName = "output" + timeStamp + ".txt";
    }
    if(args.length > 1){
      outputFileName = args[1];
    }
    
    //Set the initial prices and specials for the products.
    theProducts[0] = new Product("Apple");
    theProducts[0].setPrice(0.25);
    theProducts[1] = new Product("Orange");
    theProducts[1].setPrice(0.30);
    theProducts[2] = new Product("Banana");
	  theProducts[2].setPrice(0.15);
    theProducts[3] = new Product("Papaya");
	  theProducts[3].setPrice(0.50);
    theProducts[3].setThreeForTwoSpecial(true);
	
	  //Read the input file into an array.
    try{
      inputLines = rf.readLines(inputFileName);
    }
    catch(IOException e){
      System.out.println("Error! Unable to read " + inputFileName + ". Error Details: " + e.getMessage()); //Output the exception.         
      return;
    }

	  //For each line in input file increment the quantity of the appropriate item type.
    for(int i = 0; i < inputLines.length; i++){
      for(int j = 0; j < theProducts.length; j++){
        if(inputLines[i].equals(theProducts[j].getName())){
          int currentQuantity = theProducts[j].getQuantity();
          int newQuantity = currentQuantity + 1;
          theProducts[j].setQuantity(newQuantity);
        }
      }
    }

	  //For each item type: 	
    for(int i = 0; i < theProducts.length; i++){
	    //Calculate the subtotal
      double subtotal = theProducts[i].getQuantity() * theProducts[i].getPrice();
		  //Calculate any discounts (papaya are 3 for the price of 2)
      if(theProducts[i].getThreeForTwoSpecial() == true){
        int quotient = theProducts[i].getQuantity() / 3; //Determine how many discounts are present.
        subtotal = subtotal - (quotient * theProducts[i].getPrice());
      }
      subtotal = Math.round(subtotal*100.0)/100.0; //Round the value to 2 decimals.
      theProducts[i].setSubtotal(subtotal); //Save the subtotal for this product, so that we can write it later.
      total = total + subtotal; //Add the subtotal to the total
    }

    //Write the output to a file.
    try{
      PrintWriter writer = new PrintWriter(outputFileName, "UTF-8"); //Open output file.
      //For each item type
      for(int i = 0; i < theProducts.length; i++){
        writer.println(theProducts[i].getName() + ": $" + df2.format(theProducts[i].getSubtotal())); //Output item data to file: "Apple: $1.00"
        //System.out.println(theProducts[i].getName() + ": $" + df2.format(theProducts[i].getSubtotal())); //Display in console.
      }
      writer.println("Total: $" + df2.format(total)); //Output total to file: "Total: $3.35"
      //System.out.println("Total: $" + df2.format(total)); //Display in console.
      writer.close(); //Close the output file.
    }
    catch (IOException e){
      System.out.println("Error! There was a problem reading the file. Error Details: "+ e.getMessage());
      return;
    }
  }
}