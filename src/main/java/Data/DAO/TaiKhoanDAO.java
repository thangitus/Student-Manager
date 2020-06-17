package Data.DAO;

import Data.entities.TaiKhoan;

import java.util.List;

public interface TaiKhoanDAO {
   public void insert(TaiKhoan taiKhoan);

   public boolean find(TaiKhoan taiKhoan);

   public void insertAll(List<TaiKhoan> list);
}
