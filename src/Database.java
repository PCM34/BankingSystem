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

  public Account getAccount(Account ac) {
    for (Account DataListIndex : dataList)
      if (ac.getAccountNum() == DataListIndex.getAccountNum()) return DataListIndex;
    return null;
  }
}