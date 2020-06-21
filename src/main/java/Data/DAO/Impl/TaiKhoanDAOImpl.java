package Data.DAO.Impl;

import Data.DAO.TaiKhoanDAO;
import Data.entities.SinhVien;
import Data.entities.TaiKhoan;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TaiKhoanDAOImpl implements TaiKhoanDAO {
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
   @Override
   public void updateMatKhau(TaiKhoan taiKhoan, String matKhau) {
      taiKhoan.setMatKhau(matKhau);
      session.flush();
   }
   @Override
   public TaiKhoan getByTaiKhoan(String taiKhoan) {
      String sql = String.format("from %s tk where tk.taiKhoan = :taiKhoan", TaiKhoan.class.getName());
      Query query = session.createQuery(sql);
      query.setParameter("taiKhoan", taiKhoan);

      return (TaiKhoan) query.getSingleResult();
   }
}
