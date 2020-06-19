package Data.DAO;

import Data.entities.TaiKhoan;

import java.util.List;

public interface TaiKhoanDAO {
   public void insert(TaiKhoan taiKhoan);

   public boolean find(TaiKhoan taiKhoan);

   public void insertAll(List<TaiKhoan> list);

   public void updateMatKhau(TaiKhoan taiKhoan, String matKhau);

   public TaiKhoan getByTaiKhoan(String taiKhoan);
}
