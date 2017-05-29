import java.util.Scanner;
import java.io.*;
import java.util.*;


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
        FileWriter usernames1 = new FileWriter("usernames.txt" , true);
        BufferedWriter bw = new BufferedWriter(usernames1);
        PrintWriter pw = new PrintWriter(bw);
        
        pw.print(username+";");  
        pw.close();
        
      }
      
      catch (FileNotFoundException e) {
        System.out.println("Error: Cannot open file for writing");
      }
      catch (IOException e) {
        System.out.println("Error: Cannot write to file");
        
      }
      try {
        FileWriter passwords1 = new FileWriter("passwords.txt" , true);
        BufferedWriter wb = new BufferedWriter(passwords1);
        PrintWriter wp = new PrintWriter(wb);
        
        wp.print(password+";");  
        wp.close();
        
      }
      
      catch (FileNotFoundException e) {
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
          ArrayList <String> usernames = new ArrayList<String>();

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
          ArrayList <String> passwords = new ArrayList<String>();
      try
      {
        BufferedReader preader = new BufferedReader(new FileReader("passwords.txt"));
        String pline;
        while ((pline = preader.readLine()) != null)
        {
          StringTokenizer tok2 = new StringTokenizer(pline, ";");
          while(tok2.hasMoreTokens()) {
            passwords.add(tok2.nextToken());
          }
        }
        preader.close();
      }
      
      catch (Exception e)
      {
        System.err.format("Exception occurred trying to read '%s'.", "passwords.txt");
        e.printStackTrace();
        
      }

      
      
      
      if((usernames.contains(inpUser)) && (passwords.contains(inpPass))) {
        int ulocation = usernames.indexOf(inpUser);
        int plocation = passwords.indexOf(inpPass);
        
        if (ulocation == plocation){
          bankaccounts bank = new bankaccounts();
          bank.bankmenu(); 
        }
        
      }
      else {
        System.out.print("Username or password is Incorrect!\n");
        loggingin(inpUser,inpPass);
        
      }
      scan.close();
      
        
      
      
    }
  }



public static void main(String[] args){
  Login login = new Login();
  login.logging();
  
}
}
