package Data.DAO;

import Data.entities.PhucKhao;

import java.util.List;

public interface PhucKhaoDAO {
   public void insert(PhucKhao phucKhao);
   public List<PhucKhao> getAll();
   public void delete(PhucKhao phucKhao);
   public PhucKhao get(String mssv,String maMon,String cotDiem);
}
