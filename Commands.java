import java.util.*;

public class Commands {

  public static int money = 100;
 
  public String checkInventory() {
    Inventory inven = new Inventory();
    String returninv="Inventory has ";
    for (int i=0;i<inven.inv.size();i++){
        returninv+=inven.inv.get(i);
        returninv+=" ";
    }
    return returninv;
  }

  public String help() {
    return "Commands: SHOW INV, BET MONEY, SHOP, COINS, BUY, STOCKS, END";
  }

  public int robBank(int usernumber) {
    int returnvalue = 0;
    // ressetting money earned
    int moneyearned = 0;

    double chosenNumber = 0.0;
    chosenNumber = Math.random()*10;
    // now we need to convert to int
    int choose = (int) chosenNumber;
    System.out.println("The number was "+choose);
    
    if (choose == usernumber) {
      moneyearned = 10 * usernumber;
      returnvalue = moneyearned;
      
    }
    else {
      int moneylose = 10 * usernumber;
      returnvalue -= moneylose;
      
    }
    
    return returnvalue;
  }
  
  public int coincount() {
    return money;
  }

  public ArrayList<String> viewShop() {
    Inventory inv = new Inventory();
    return inv.shop;
  }
  
  public int BUY(String item){
    item = item.toUpperCase();
    Inventory inven = new Inventory();
    switch(item){
        case "PHONE":
          if (money >= 400){
            inven.inv.add("PHONE");
            money-=400;
            System.out.println(item + " was bought");
          }
          else{ 
            System.out.println("Not enough money");
          }
          break;
      
        case "HEADPHONES":
          if (money>=100){
            inven.inv.add("HEADPHONE");
            money-=100;
            System.out.println(item + " was bought");
          }
          else{ 
            System.out.println("Not enough money");
          }
          break;
      
        case "EARBUDS":
          if (money>=50){
            inven.inv.add("EARBUDS");
            money-=50;
            System.out.println(item + " was bought");
          }
          else { 
              System.out.println("Not enough money");
          }
        break;

        case "HOUSE":
          if (money>=1000){
            inven.inv.add("HOUSE");
            money-=1000;
            System.out.println(item + " was bought");
          }
          else { 
            System.out.println("Not enough money");
          }
          break;

        case "SMARTWATCH":
          if (money>=70){
            inven.inv.add("SMARTWATCH");
            money-=70;
            System.out.println(item + " was bought");
          }
          else { 
            System.out.println("Not enough money");
          }
          break;

        case "WATCH":
          if (money>=30){
            inven.inv.add("WATCH");
            money-=30;
            System.out.println(item + " was bought");
          }
          else{ 
            System.out.println("Not enough money");
          }
          break;
    }
    int returnvalue = money;
    System.out.println(String.valueOf(returnvalue)+" coins is left");
    
    return returnvalue;
  }
  public int STOCKS(int moneyinvested){
    double chosenNumber = Math.random()*10;
    // now we need to convert to int
    int choose = (int) chosenNumber;
    
    if(choose%2==0){
      moneyinvested+=choose*6;
      
      moneyinvested= (int) moneyinvested;
      money+=moneyinvested;
    }
    
    
    int returnvalue=money;
    return returnvalue;
    
  }
}


