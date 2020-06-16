package Data.DAO.Impl;

import Data.DAO.SinhVienDAO;
import Data.HibernateUtils;
import Data.entities.SinhVien;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SinhVienDAOImpl implements SinhVienDAO {
    private static Session session;
    public static void setSession(Session session) {
        SinhVienDAOImpl.session = session;
    }
    @Override
    public List<SinhVien> getAll() {
        String sql = String.format("from %s", SinhVien.class.getName());
        Query query = session.createQuery(sql);
        List<SinhVien> result = query.getResultList();
        return result;
    }

    @Override
    public List<SinhVien> getByMaLop(String maLop) {
        String sql = String.format("from %s sv where sv.maLop = :maLop", SinhVien.class.getName());
        Query query = session.createQuery(sql);
        query.setParameter("maLop", maLop);
        List<SinhVien> result = query.getResultList();
        return result;
    }

    @Override
    public SinhVien getByMSSV(String mssv) {
        String sql = String.format("from %s sv where sv.mssv = :mssv", SinhVien.class.getName());
        Query query = session.createQuery(sql);
        query.setParameter("mssv", mssv);
        SinhVien result = (SinhVien) query.getSingleResult();
        return result;
    }

    @Override
    public void insert(SinhVien sv) {
        session.persist(sv);
    }

    @Override
    public void insertAll(List<SinhVien> sv) {
        sv.forEach(e -> {
            session.persist(e);
        });
    }
}
