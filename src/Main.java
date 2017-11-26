import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner inpt = new Scanner(System.in);
    Database db = new Database();
    boolean loginSucceeded = false;

    System.out.println("Welcome to Bluetech Banking");
    System.out.println("----------------------------------------");

    do {
      System.out.println("Please Enter your information: ");
      System.out.print("Username: ");
      String usrName = inpt.next(); // TODO Sanitize Input
      System.out.print("Password: ");
      String usrPasswd = inpt.next();

      if (db.checkCredentials(usrName, usrPasswd)) {
        System.out.println("Login succeeded\n");
        loginSucceeded = true;
      } else {
        System.out.println("Login failed. Please try again\n");
      }
    } while (!loginSucceeded);

    // TODO Create Menu
  }
}
