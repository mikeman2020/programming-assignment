//Logging in

import java.util.Scanner;
import java.io.*;

public class Login {
  
  //Method for creating a user & passw.
  public void logging(){
    String username = "";
    String password = "";
    
    Scanner scan = new Scanner (System.in);
    Scanner scan2 = new Scanner (System.in);
    Scanner inp = new Scanner (System.in);
    System.out.println("Please Select an option:\nCreate an Account: 1\nLogin: 2");
    int input = inp.nextInt();
    inp.close();
    
    if(input == 1){
      
      
      
      System.out.print("Create a Username: ");
      String user = scan.nextLine();
      System.out.print("Create a Password: ");
      String pass = scan2.nextLine();
      username = user;
      password = pass;
      try {
        PrintWriter out = new PrintWriter(new FileWriter("accounts.txt"));
        out.print(username+" ");  
        out.println(password);
        out.close();
   
        
      } catch (FileNotFoundException e) {
        System.out.println("Error: Cannot open file for writing");
      }
      catch (IOException e) {
        System.out.println("Error: Cannot write to file");
        
      }
      loggingin(username,password);
    }
    
    else if(input == 2){
      loggingin(username,password);
    }
  scan.close();
  scan2.close();
  }
  
  public static void loggingin(String user,String pass){
    Scanner scan = new Scanner (System.in);
    
    //While loop allows the user to re-enter info if access is denied
    boolean index = true;
    while(index){  
      System.out.print("Username: ");
      String inpUser = scan.nextLine();
      System.out.print("Password: ");
      // gets input from user
      String inpPass = scan.nextLine();
      
      
      if (inpUser.equals(user) && inpPass.equals(pass)) {
        System.out.print("Access Granted!");
        index = false;
        bankaccounts bank = new bankaccounts();
        bank.bankmenu();
        
      } else {
        System.out.print("Access Denied!\n");
      }
      
    }
    scan.close();
  }

  
  
  
  public static void main(String[] args){
    Login login = new Login();
    login.logging();

  }
}



