import java.util.Scanner;

@SuppressWarnings("CanBeFinal")
class Main {
  private static  Database db = new Database();
  private static final Scanner inpt = new Scanner(System.in);
  private static boolean loginSucceeded = false;
  private static Main main = new Main();
  private static Account ac;

  public static void main(String[] args) {
    System.out.println("Welcome to Bluetech Banking");
    System.out.println("----------------------------------------");
    System.out.println("  1. Login");
    System.out.println("  2. Sign up");
    System.out.print("Please select an option: ");
    String loginChoice = inpt.next();
    String choice;

    if (loginChoice.equals("2")) {
      System.out.println("Please Enter your information: ");
      System.out.print("Full Name: ");
      String fullName = inpt.nextLine();
      inpt.next();
      System.out.print("Username: ");
      String usrName = inpt.next().trim();
      System.out.print("Password: ");
      String usrPasswd = inpt.next();

      Account act = new Account(fullName, usrName, usrPasswd);
      db.addAccount(act);
    }
    do {
      System.out.println("\nPlease Enter your Login information: ");
      System.out.print("Username: ");
      String usrName = inpt.next().trim();
      System.out.print("Password: ");
      String usrPasswd = inpt.next();

      ac = main.authenticate(usrName, usrPasswd);
    } while (!loginSucceeded);

    do {
      assert ac != null;      // Replace assert with better error handling
      System.out.println("Welcome " + ac.getFullName());
      System.out.println("Account number:" + ac.getAccountNum());
      System.out.println("----------------------------------------");
      System.out.println("  1. View Balance");
      System.out.println("  2. Transfer funds"); // More options to be implemented
      System.out.println("  3. Deposit funds");
      System.out.println("  4. Withdraw funds");
      System.out.println("  5. Delete account");
      System.out.println("  6. Exit/Logout");
      System.out.print("Please select an option: ");
      choice = inpt.next();
      System.out.println(); //For spacing

      switch (choice) {
        case "1":
          System.out.println("Balance: $" + ac.getBalance());
          break;
        case "2":
          System.out.println("Transfer Funds:\n----------------------------------------");
          System.out.println("Current account number: " + ac.getAccountNum());
          System.out.print("Destination account number: ");
          int reciveNum = inpt.nextInt();
          System.out.print("Amount: $");
          double amnt = inpt.nextDouble();

          main.transferFunds(reciveNum, amnt);
          break;
        case "3":
          System.out.print("How much would like to deposit? $");
          double deposit = inpt.nextDouble();
          ac.setBalance(deposit + ac.getBalance());
          System.out.println("Balance is now: $" + ac.getBalance());
          break;
        case "4":
          System.out.print("How much would like to withdraw? $");
          double withdraw = inpt.nextDouble();
          ac.setBalance(ac.getBalance() - withdraw);
          System.out.println("Balance is now: $" + ac.getBalance());
          break;
        case "5":
          if (db.delAccount(ac))
            System.out.println("Account successfully deleted");
          else
            System.out.println("Deletion failed, please try again.");
          break;
        case "6":
          System.out.println("Thank you for using BlueTech Banking!");
          break;
        default:
          System.out.println("Invalid menu option");
          break;
      }
      System.out.println();
    } while (!(choice.equals("5") || choice.equals("6")));
  }

  /**
   * authenticate checks the database for valid credentials. Once it finds an
   * existing pair of credentials it makes loginSucceeded = true. In order to
   * make to login screen cease to repeat.
   *
   * @param usrName       username passed from the user
   * @param usrPasswd     password passed from the user
   * @return              an account for the main method to be able to access
   */
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

  /**
   * transferFunds checks the database for the account tied to acctNum. Once it
   * finds the account, the transfer occurs with addition and subtraction. If
   * transferFunds does not find the account an error message is printed and
   * handled.
   *
   * @param acctNum       the account number the database has to find.
   * @param amnt          the amount to be transferred to acctNum.
   */
  private void transferFunds(int acctNum, double amnt) {
    Account targetAccnt = db.searchAccount(acctNum);
    try {
      targetAccnt.setBalance(targetAccnt.getBalance() + amnt);
      ac.setBalance(ac.getBalance()-amnt);
      System.out.println("Transfer Successful");
    } catch (Exception e) {
      System.out.println("Account not found. Please try again");
    }
  }
}
