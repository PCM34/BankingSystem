import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner inpt = new Scanner(System.in);
    Database db = new Database();
    Account ac = null;
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
        ac = db.getAccount(usrName);
      } else {
        System.out.println("Login failed. Please try again\n");
      }
    } while (!loginSucceeded);

    String choice;

    System.out.println("Welcome " + ac.getFirstName() + " " + ac.getLastName());
    System.out.println("Account number:" + ac.getAccountNum());
    System.out.println("----------------------------------------");
    System.out.println("  1. View Balance");
    System.out.println("  2. Transfer funds"); // More options to be implemented
    System.out.println("  3. Delete account");
    System.out.print("Please select an option: ");
    choice = inpt.next();

    switch (choice) {
      case "1": // TODO Create main menu logic
        break;
    }
    // TODO Create option to create account.
  }
}
