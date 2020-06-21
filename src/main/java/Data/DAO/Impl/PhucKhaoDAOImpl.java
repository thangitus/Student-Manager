package Data.DAO.Impl;

import Data.DAO.PhucKhaoDAO;
import Data.entities.PhucKhao;
import Data.entities.SinhVien;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PhucKhaoDAOImpl implements PhucKhaoDAO {
   private static Session session;

   public static void setSession(Session session) {
      PhucKhaoDAOImpl.session = session;
   }

   @Override
   public void insert(PhucKhao phucKhao) {
      session.saveOrUpdate(phucKhao);
   }
   @Override
   public List<PhucKhao> getAll() {
      String sql = String.format("from %s", PhucKhao.class.getName());
      Query query = session.createQuery(sql);
      List<PhucKhao> result = query.getResultList();
      return result;
   }
   @Override
   public void delete(PhucKhao phucKhao) {
      session.delete(phucKhao);
   }
   @Override
   public PhucKhao get(String mssv, String maMon, String cotDiem) {
      String sql = String.format("from %s pk where pk.mssv = :mssv and pk.maMon = :maMon and pk.cotDiem = :cotDiem", PhucKhao.class.getName());
      Query query = session.createQuery(sql);
      query.setParameter("mssv", mssv);
      query.setParameter("maMon", maMon);
      query.setParameter("cotDiem", cotDiem);
      return (PhucKhao) query.getSingleResult();
   }
}
