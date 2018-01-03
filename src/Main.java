import java.util.Scanner;

public class Main {
  private static  Database db = new Database();
  private static Scanner inpt = new Scanner(System.in);
  private static boolean loginSucceeded = false;
  private static Main main = new Main();

  public static void main(String[] args) {
    Account ac;
    System.out.println("Welcome to Bluetech Banking");
    System.out.println("----------------------------------------");
    System.out.println("  1. Login");
    System.out.println("  2. Sign up");
    System.out.print("Please select an option: ");
    String loginChoice = inpt.next();

    if (loginChoice.equals("2")) {
      System.out.println("Please Enter your information: ");
      System.out.print("Full Name: ");
      String fullName = inpt.next();
      System.out.print("Username: ");
      String usrName = inpt.next().trim();
      System.out.print("Password: ");
      String usrPasswd = inpt.next();

      Account act = new Account(fullName, usrName, usrPasswd);
      db.addAccount(act);
    }
    do {
      System.out.println("Please Enter your Login information: ");
      System.out.print("Username: ");
      String usrName = inpt.next().trim();
      System.out.print("Password: ");
      String usrPasswd = inpt.next();

      ac = main.authenticate(usrName, usrPasswd);
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
        System.out.println("Balance: $" + ac.getBalance());
        break;
      case "2":
        break;
      case "3":
        if (db.delAccount(ac))
          System.out.println("Account successfully deleted");
        else
          System.out.println("Deletion failed, please try again.");
        break;
      default:
        System.out.println("Invalid menu option");
        break;
    }
  }
  // TODO Create option to create account.

  private Account authenticate(String usrName, String usrPasswd) {
    if (db.checkCredentials(usrName, usrPasswd)) {
      System.out.println("Login succeeded\n");
      loginSucceeded = true;
      return db.getAccount(usrName);
    } else {
      System.out.println("Login failed. Please try again\n");
      return null;
    }
  }
}
