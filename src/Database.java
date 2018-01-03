import java.util.ArrayList;

class Database {
  private ArrayList<Account> dataList;

  Database() {
    dataList = new ArrayList<>();
  }

  boolean addAccount(Account ac) {
    return dataList.add(ac);
  }

  boolean delAccount(Account ac) {
    return dataList.remove(ac);
    // TODO Check if delAccount works for given context
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