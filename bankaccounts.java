//Bank accounts
import java.util.*;
import java.io.*;

public class bankaccounts {
  
  // Cheque & Savings Variables
  //This is just a starting point to store the values of each bank account
  public int cheque = 0;
  public int savings = 0;


  
   ArrayList <Integer> cheqlist = new ArrayList <Integer>();
   ArrayList <Integer> savlist = new ArrayList <Integer>();
  Scanner sc = new Scanner(System.in);
  
  //set methods Constructor
  public bankaccounts() {
    this.setcheque(cheque);
    this.setsavings(savings);
  }
    
  //ading funds to cheque
  public void setcheque(int newcheq){
    this.cheque = cheque + newcheq;
  }
  //adding funds to savings
  public void setsavings(int newsavings){
    this.savings = savings + newsavings; 
  }
  
  // MENU: Select account to deposit
  // Allows user to select which account to deposit money into
  public void addfunds(int index1, int index2){
    
    System.out.println("Which account would you like to add funds to ?; \nCheque: 1\nSavings: 2");
    int acc = sc.nextInt();
    System.out.println("How much will you be depositing ?");
    int dep =sc.nextInt();
    
    if(acc == 1){
      setcheque(dep);
      cheqlist.add(index1,cheque);
      
        
            try {
        FileWriter cheq = new FileWriter("cheque.txt", true);
        BufferedWriter wb = new BufferedWriter(cheq);
        PrintWriter wp = new PrintWriter(wb);
        
        wp.print(cheque+";");  
        wp.close();
        
      }
      
      catch (FileNotFoundException e) {
        System.out.println("Error: Cannot open file for writing");
      }
      catch (IOException e) {
        System.out.println("Error: Cannot write to file");
        
      }
      
      System.out.println("Your balance is now : ");
      System.out.println("Cheque: $"+cheque);
      System.out.println("Cheque list: $"+cheqlist);
      back2accounts();
      back2menu();
    }
    else if(acc == 2){
      setsavings(dep);
      savlist.add(index1,savings);
      try {
        FileWriter save = new FileWriter("savings.txt", true);
        BufferedWriter wb = new BufferedWriter(save);
        PrintWriter wp = new PrintWriter(wb);
        
        wp.print(savings+";");  
        wp.close();
        
      }
      
      catch (FileNotFoundException e) {
        System.out.println("Error: Cannot open file for writing");
      }
      catch (IOException e) {
        System.out.println("Error: Cannot write to file");
        
      }
      System.out.println("Savings: "+savings);
      back2accounts();
      back2menu();
    }
  }
  public void uplists(){
    ArrayList <String> usernames = new ArrayList <String>();
    try
      {
        BufferedReader ureader = new BufferedReader(new FileReader("usernames.txt"));
        String uline;
        while ((uline = ureader.readLine()) != null)
        {
          StringTokenizer tok = new StringTokenizer(uline, ";");
          while(tok.hasMoreTokens()) {
            usernames.add(tok.nextToken());
            
          }
        }
        ureader.close();
      }
      catch (Exception e)
      {
        System.err.format("Exception occurred trying to read '%s'.", "usernames.txt");
        e.printStackTrace();
        
      }
  }
      
  //WITHDRAW METHOD
  //Allows User to select an account and withdraw
  public void withdraw(){
    System.out.println("Select an Account:\nCHEQUE: 1\nSAVINGS: 2");
    int acc = sc.nextInt();
    if(acc == 1){
      System.out.println("Cheque: $"+cheque);
      System.out.println("ENTER AMOUNT TO WITHDRAW FROM CHEQUE: ");
      int cheqamount = sc.nextInt();
      
      cheque = cheque - cheqamount;
      if(cheque<0){
        cheque = cheque + cheqamount;
        System.out.println("Insufficient funds");
        System.out.println("Cheque: $"+cheque);
        back2menu();
      }
      else{
        System.out.println("FUNDS WITHDRAWN FROM CHEQUE: "+cheqamount);
        System.out.println("Cheque: $"+cheque+"\nSavings: $"+savings);
        back2menu();
      }
    }
    if(acc == 2){
      System.out.println("Savings: $"+savings);
      System.out.println("ENTER AMOUNT TO WITHDRAW FROM SAVINGS: ");
      int savingsamount = sc.nextInt();
      savings = savings - savingsamount;
      if(savings<0){
        savings = savings + savingsamount;
        System.out.println("Insufficient funds");
        System.out.println("Savings: $"+savings);
        back2menu();
      }
      else{
        System.out.println("FUNDS WITHDRAWN FROM SAVINGS: "+savingsamount);
        System.out.println("Savings: $"+savings);
        back2menu();
      }
    }
  }
  //MENU: Option>go back to mainmenu
  //Gives the user an option to go to the main menu. Looks neater as well doing it this way
  public void back2menu(){
    System.out.println("Would you like to go back to the main menu ? y/n ");
    String yesno = sc.next();
    if(yesno.equals("y")){
           Login login = new Login();
      login.logging();
    }
    else if(yesno.equals("n")){
      System.out.println("Logging out ... ");
      Login login = new Login();
      login.logging();
      
    }
  }
  //MENU: Option>go back to selectaccount for deposit
  //Gives the user the option of going back to account deposit selection page
  public void back2accounts()
  {
    System.out.println("Would you like to go back to Select an account to add funds ? y/n ");
    String yesno = sc.next();
    if(yesno.equals("y")){
      back2accounts();
    }
    else if(yesno.equals("n")){
      System.out.println("Goodbye!");
    }
    else{
      System.out.println("Please type 'y' or 'n'" );
      back2accounts();}
  }

  //TRANSFER METHOD
  //Allows the user to transfer money from 1 account to another
  public void transfer(){
    System.out.println("Enter a number to Select an option:\n\nTRANSFER FROM:\nCHEQUE: 1\nSAVINGS: 2");
    int option = sc.nextInt();
    if(option == 1){
      
      System.out.println("CHEQUE: "+cheque);
      System.out.println("ENTER AMOUNT TO TRANSFER: ");
      int chqamount = sc.nextInt();
      int newcheq = cheque - chqamount;
      int newsavings = savings + chqamount;
      if(newcheq<0){
        System.out.println("Insufficient funds");
        System.out.println("Cheque: $"+cheque+"\nSavings: $"+savings);
        back2menu();
      }
      else {
        cheque = newcheq;
        savings = newsavings;
        System.out.println("TRANSFER SUCCESS");
        System.out.println("=================");
        System.out.println("$"+chqamount+" FROM: CHEQUE  TO SAVINGS");
        System.out.println("Cheque: $"+cheque+"\nSavings: $"+savings);
        back2menu();
      }
    }
    else if(option == 2){
      System.out.println("SAVINGS: "+savings);
      System.out.println("ENTER AMOUNT TO TRANSFER: ");
      int savamount = sc.nextInt();
      int newsavings = savings - savamount;
      int newcheq = cheque + savamount;
      if(newsavings<0){
        System.out.println("Insufficient funds");
        System.out.println("Cheque: $"+cheque+"\nSavings: $"+savings);
        back2menu();
      }
      else {
        cheque = newcheq;
        savings = newsavings;
        System.out.println("TRANSFER SUCCESS");
        System.out.println("=================");
        System.out.println("$"+savamount+" FROM: SAVINGS TO CHEQUE");
        System.out.println("Cheque: $"+cheque+"\nSavings: $"+savings);
        back2menu();
      }        
    }
  }
  //MENU: after logging in success
  //Menu for selecting options after logging in
  public void bankmenu(int indexuser, int indexpass){
    int indexu = indexuser;
    int indexp = indexpass;
    System.out.println("\n\nPlease enter a number to select an Option:\n View account balances: 1 \n Add funds: 2\n Withdraw Funds: 3\n Transfer funds: 4");
    int input = sc.nextInt();
    if(input == 1){
      System.out.println("==== ACCOUNTS ====");
      System.out.println("Cheque: $"+cheqlist(indexuser)+"\nSavings: $"+savlist(indexuser));
      back2menu();
      
    }
    else if(input == 2){
      addfunds(indexu,indexp);
    }
    else if(input == 3){
      withdraw();
    }
    
    else if(input == 4){
      transfer();
      
      }
    }
  }
