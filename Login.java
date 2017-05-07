import java.util.Scanner; // I use scanner because it's command line.

public class Login {
public static void main(String[] args){
  
    Scanner scan = new Scanner (System.in);
    Scanner keyboard = new Scanner (System.in);
   /* System.out.print("Username: ");
    String user = scan.nextLine();
    System.out.print("Password: ");
    String pass = scan.nextLine(); // looks at selected file in scan
    
    System.out.print("LoginUser: ");
    String inpUser = keyboard.nextLine();
    System.out.print("LoginPassword: ");
    String inpPass = keyboard.nextLine(); // gets input from user
    scan.close();
    keyboard.close();*/
    
    boolean index = true;
    while(index)
    { System.out.print("Create a Username: ");
      String user = scan.nextLine();
      System.out.print("Create a Password: ");
      String pass = scan.nextLine(); // looks at selected file in scan
      
      System.out.print("Username: ");
      String inpUser = keyboard.nextLine();
      System.out.print("Password: ");
      String inpPass = keyboard.nextLine(); // gets input from user
      
      
      if (inpUser.equals(user) && inpPass.equals(pass)) {
        System.out.print("Access Granted!");
        index = false;
      } else {
        System.out.print("Access Denied!");
        
      }
      
      
    }
}
}