import java.util.ArrayList;

public class Database {
  private ArrayList<Account> dataList;

  Database() {
    dataList = new ArrayList<>();
  }

  public boolean addAccount(Account ac) {
    return dataList.add(ac);
  }

  public boolean delAccount(Account ac) {
    return dataList.remove(ac);
    // TODO Check if delAccount works for given context
  }

  public Account getAccount(String UserName) {
    for (Account DataListIndex : dataList)
      if (DataListIndex.getUserName().equals(UserName)) return DataListIndex;
    return null;
  }

  public boolean checkCredentials(String UserName, String passwd) {
    for (Account ac:dataList)
      if (ac.getUserName().equals(UserName) && ac.getPassword().equals(passwd)) return true;
    return false;
  }
}