package Data.DAO;

import Data.entities.MonHoc;

import java.util.List;

public interface MonHocDAO {
   public void insert(MonHoc mh);
   public void insertAll(List<MonHoc> mh);

   public MonHoc getByMaMon(String maMon);

}
