package Data.DAO.Impl;

import Data.DAO.ChiTietMonHocDAO;
import Data.HibernateUtils;
import Data.entities.ChiTietMonHoc;
import View.TeacherUI;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ChiTietMonHocDAOImpl implements ChiTietMonHocDAO {
   private static Session session;

   public static void setSession(Session session) {
      ChiTietMonHocDAOImpl.session = session;
   }

   @Override
   public void insert(ChiTietMonHoc ctmh) {
      session.persist(ctmh);
   }

   @Override
   public void insertAll(List<ChiTietMonHoc> ctmh) {
      ctmh.forEach(e -> {
         session.persist(e);
      });
   }

   @Override
   public void importBangDiem(List<ChiTietMonHoc> ctmh) {
      ctmh.forEach(e->{
         session.saveOrUpdate(e);
      });
   }

   @Override
   public List<ChiTietMonHoc> getAll() {
      String sql = String.format("from %s", ChiTietMonHoc.class.getName());
      Query query = session.createQuery(sql);
      List<ChiTietMonHoc> result = query.getResultList();
      return result;
   }

   @Override
   public List<ChiTietMonHoc> getByMaLopMaMon(String maLop, String maMon) {
      if (maLop == null && maMon == null)
         return getAll();
      String sql;
      Query query;
      if (maLop != null && maMon != null) {
         sql = String.format("from %s ctmh where ctmh.maLop = :maLop and ctmh.maMon = :maMon", ChiTietMonHoc.class.getName());
         query = session.createQuery(sql);
         query.setParameter("maLop", maLop);
         query.setParameter("maMon", maMon);
      } else {
         sql = String.format("from %s ctmh where ctmh.maLop = :maLop", ChiTietMonHoc.class.getName());
         query = session.createQuery(sql);
         query.setParameter("maLop", maLop);
      }
      List<ChiTietMonHoc> result = query.getResultList();
      return result;
   }

   @Override
   public ChiTietMonHoc getByMaLopMaMonMssv(String maLop, String maMon, String mssv) {
      String sql = String.format("from %s ctmh where ctmh.maLop = :maLop and ctmh.maMon = :maMon and ctmh.mssv = :mssv", ChiTietMonHoc.class.getName());
      Query query = session.createQuery(sql);
      query.setParameter("maLop", maLop);
      query.setParameter("maMon", maMon);
      query.setParameter("mssv", mssv);
      ChiTietMonHoc result = (ChiTietMonHoc) query.getSingleResult();
      return result;
   }
   @Override
   public List<ChiTietMonHoc> getByMssv(String mssv) {
      String sql = String.format("from %s ctmh where ctmh.mssv = :mssv", ChiTietMonHoc.class.getName());
      Query query = session.createQuery(sql);
      query.setParameter("mssv", mssv);
      List<ChiTietMonHoc> result = query.getResultList();
      return result;
   }

   @Override
   public void updateDiem(ChiTietMonHoc ctmh, Double diemGK, Double diemCK, Double diemKhac, Double diemTong) {
      ctmh.setDiemGk(diemGK);
      ctmh.setDiemCk(diemCK);
      ctmh.setDiemKhac(diemKhac);
      ctmh.setDiemTong(diemTong);
      session.flush();
   }
   @Override
   public void delete(ChiTietMonHoc ctmh) {
      session.delete(ctmh);
      session.flush();
   }
}
