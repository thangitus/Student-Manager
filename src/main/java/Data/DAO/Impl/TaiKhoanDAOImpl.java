package Data.DAO.Impl;

import Data.DAO.TaiKhoanDAO;
import Data.entities.TaiKhoan;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

class TaiKhoanDAOImpl implements TaiKhoanDAO {
   private static Session session;
   public static void setSession(Session session) {
      TaiKhoanDAOImpl.session = session;
   }

   @Override
   public void insert(TaiKhoan taiKhoan) {
      session.persist(taiKhoan);
   }
   @Override
   public boolean find(TaiKhoan taiKhoan) {
      String sql = String.format("from %s tk where tk.taikhoan = :taikhoan and tk.matkhau = :matkhau", TaiKhoan.class.getName());
      Query query = session.createQuery(sql);
      return query.getResultList()
                  .size() != 0;
   }
   @Override
   public void insertAll(List<TaiKhoan> list) {
      list.forEach(e -> {
         session.persist(e);
      });
   }
}
