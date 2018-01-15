import java.util.ArrayList;

class Database {
  private ArrayList<Account> dataList;

  Database() {
    dataList = new ArrayList<>();
  }

  void addAccount(Account ac) {
    dataList.add(ac);
  }

  boolean delAccount(Account ac) {
    return dataList.remove(ac);
  }

  Account getAccount(String UserName) {
    for (Account DataListIndex : dataList)
      if (DataListIndex.getUserName().equals(UserName)) return DataListIndex;
    return null;
  }

  boolean checkCredentials(String UserName, String passwd) {
    for (Account ac:dataList)
      if (ac.getUserName().equals(UserName) && ac.getPassword().equals(passwd)) return true;
    return false;
  }

  Account searchAccount(int acctNum) {
    for (Account ac : dataList) {
      if (ac.getAccountNum() == acctNum)
        return ac;
    }
    return null;
  }
}