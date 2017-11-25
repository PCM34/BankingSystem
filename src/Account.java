public class Account {
  private String firstName;
  private String lastName;
  private int Balance;
  private int accountNum;

  public Account(String fullName) {
    firstName = fullName.substring(0, fullName.indexOf(" "));
    lastName = fullName.substring(fullName.indexOf(" ")+1);
    Balance = 0;
    //Account num logic to be finalized. Now proof of concept.
    accountNum = (int) ((900000000 * Math.random()) + 10000000);
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAccountNum() {
    return accountNum;
  }

  public int getBalance() {
    return Balance;
  }

}
