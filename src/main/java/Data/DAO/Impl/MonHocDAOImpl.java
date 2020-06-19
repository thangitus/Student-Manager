package Data.DAO.Impl;

import Data.DAO.MonHocDAO;
import Data.entities.MonHoc;
import Data.entities.SinhVien;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MonHocDAOImpl implements MonHocDAO {
   private static Session session;
   public static void setSession(Session session) {
      MonHocDAOImpl.session = session;
   }
   @Override
   public void insert(MonHoc mh) {
      session.saveOrUpdate(mh);
      session.flush();
   }
   @Override
   public void insertAll(List<MonHoc> mh) {
      mh.forEach(this::insert);
   }
   @Override
   public MonHoc getByMaMon(String maMon) {
      String sql = String.format("from %s mh where mh.maMon = :maMon", MonHoc.class.getName());
      Query query = session.createQuery(sql);
      query.setParameter("maMon", maMon);
      MonHoc result = (MonHoc) query.getSingleResult();
      return result;
   }
}
