//Logging in

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;


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
        out.append(username+" ");  
        out.append(password);
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
      // gets input from user
      System.out.print("Username: ");
      String inpUser = scan.nextLine();
      System.out.print("Password: ");
      String inpPass = scan.nextLine();
      
      
      
      try {
        BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
        String strLine;
        
//Read File Line By Line
        while ((strLine = reader.readLine()) != null)   {
          // Split line into username & password
          StringTokenizer userpass = new StringTokenizer(strLine," ");
          while(userpass.hasMoreTokens()) { 
            String testuser = userpass.nextToken(); 
            String testpass = userpass.nextToken(); 
            reader.close();
            
            
            
            if (inpUser.equals(testuser) && inpPass.equals(testpass)) {
              System.out.print("Access Granted!");
              index = false;
              bankaccounts bank = new bankaccounts();
              bank.bankmenu();
              
            }
            else {
              System.out.print("Access Denied!\n");
              loggingin(inpUser,inpPass);
            }
            
          }
        }
      }
      catch (FileNotFoundException e) {
        System.out.println("Error: Cannot open file for writing");
      }
      catch (IOException e) {
        System.out.println("Error: Cannot write to file");
        
      }
      
    }
    scan.close();
  }
  
  
  
  
  public static void main(String[] args){
    Login login = new Login();
    login.logging();
    
  }
}
