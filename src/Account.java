public class Account {
  private String UserName;
  private String firstName;
  private String lastName;
  private String password;
  private double Balance;
  private int accountNum;

  Account(String fullName, String UsrName, String UsrPassword) {
    firstName = fullName.substring(0, fullName.indexOf(" "));
    lastName = fullName.substring(fullName.indexOf(" ")+1);
    UserName = UsrName;
    password = UsrPassword;
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

  public String getUserName() {
    return UserName;
  }

  public int getAccountNum() {
    return accountNum;
  }

  public double getBalance() {
    return Balance;
  }

  public void setBalance(double Balance) {
    this.Balance = Balance;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
