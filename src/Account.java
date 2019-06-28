class Account {
  private final String UserName;
  private final String fullName;
  private String password;
  private double Balance;
  private final int accountNum;

  Account(String fullName, String UsrName, String UsrPassword) {
    this.fullName = fullName;
    UserName = UsrName;
    password = UsrPassword;
    Balance = 0;
    //Account num logic to be finalized. Now proof of concept.
    accountNum = (int) ((900000000 * Math.random()) + 10000000);
  }

  String getFullName() {
    return fullName;
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
