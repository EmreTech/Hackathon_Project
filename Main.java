import java.util.*;
import java.io.*;

public class Main {

  public static Scanner scan = new Scanner(System.in);
  public static Scanner scan2= new Scanner(System.in);
  public static Scanner scan3= new Scanner(System.in);
  public Files files = new Files();
  public File save = new File(System.getProperty("user.dir") + "/save/Save.txt");

  public static void main(String[] args) {
    // This is to check if user wants to start and if user wants to start then it will run the program
    System.out.println("Type START to start game and END to end game" );
    String startend = scan2.nextLine();
    startend = startend.toUpperCase();

    // Starting game
    Main main = new Main();
    main.Loop(startend); // Runs the game loop
    scan.close();
  }

  /*private void loadSave() {  Unused code
    try {
      if (save.exists()) {
        files.readLineFromFile(save, );
      }
      else createSave(save)
    } catch (IOException e) {

    }
  }

  private void createSave(File file) {
    files.createFile(file);
  }

  private void Save() {

  }*/

  public void Loop(String startend) { // Game Loop
    while (startend.equals("START")) {
      System.out.println("Type a command");
      String input = scan.nextLine();
      startend = Main.command(input, startend);

      if(startend=="END") break;//Checking if user wants to end game
    }
  }

  public static String command(String text, String startend) {
     // Sets up the function
     Inventory inventory= new Inventory();
    Commands commands = new Commands();
    text = text.toUpperCase(); 
    String output = "";
                                                        
      switch (text) { // Master list of all commands from Commands class
        case "HELP": // Shows all commands to the user
          output = commands.help();
          break;

        case "SHOW INV": // Shows the users inventory
          output = commands.checkInventory();
          break;

        case "COINS":  //shows the coins that user has
          output = String.valueOf(commands.coincount())+ " is how much coins you have"; 
          
          break;

        case "BET MONEY": // Bets an amount of money that you can loose or gain
          System.out.println("Type a number from 0-10");
          int inputbank = scan3.nextInt();
          int returnvalue = commands.robBank(inputbank);

          if (returnvalue > 0) output = returnvalue + " coins gained";
          else output = returnvalue + " coins lost ";

          Commands.money += returnvalue;
          System.out.println(String.valueOf(commands.coincount()) + " left");
          break;
          
        case "SHOP": // Shows the shop's items
          System.out.println("Welcome to the Shop! View the contents below:" + "\n" + commands.viewShop());
          break;

        case "BUY": // Buys
          System.out.println("Type what Item you want to buy");
          String buyitem = scan3.nextLine();
          buyitem=buyitem.toUpperCase();
          returnvalue = commands.BUY(buyitem);
          Commands.money = returnvalue;
          break;
          
        case "STOCKS": // Invest in the stock market
          System.out.println("How much money do you want to invest");
          int valuething=scan2.nextInt();
          returnvalue=commands.STOCKS(valuething);
          Commands.money=returnvalue;
          break;
        
        case "END":
          startend = "END";
          break;

        case "":
          output = "";
          break;

        default:
          output = "I'm sorry, but this command is mispelled or not a function. Type   HELP for help.";
          break;
        }
      if (!output.equals("")) System.out.println(output); // Prints output from Master list of all commands
      //System.out.println(!output.equals(null));
      
    return startend;
  }

}