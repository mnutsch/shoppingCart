
/**************************************************************************************************************************
* Name: Product.java
* Description: This file contains a class for storing and interacting with product information.
**************************************************************************************************************************/

public class Product{
  private String name; //The name of the product being sold.
  private double price = 0.0; //The per unit price of the product.
  private int quantity = 0; //The quantity that the user is purchasing.
  private boolean threeForTwoSpecial = false; //Whether or not this item is included in the 3 for 2 special.
  private double subtotal = 0.0; //The subtotal for this product in the user's order.
  
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
