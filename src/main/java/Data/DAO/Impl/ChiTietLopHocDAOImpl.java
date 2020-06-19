package Data.DAO.Impl;

import Data.DAO.ChiTietLopHocDAO;
import Data.DAO.ChiTietMonHocDAO;
import Data.DAO.SinhVienDAO;
import Data.HibernateUtils;
import Data.entities.ChiTietLopHoc;
import Data.entities.ChiTietMonHoc;
import Data.entities.SinhVien;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ChiTietLopHocDAOImpl implements ChiTietLopHocDAO {
    private static Session session;

    public static void setSession(Session session){
        ChiTietLopHocDAOImpl.session = session;
    }

    @Override
    public void insert(ChiTietLopHoc ctlh) {
        session.persist(ctlh);
        ChiTietMonHocDAOImpl.setSession(session);
        ChiTietMonHocDAO ctmhDAO = new ChiTietMonHocDAOImpl();
        SinhVienDAOImpl.setSession(session);
        SinhVienDAO svDAO = new SinhVienDAOImpl();

        List<SinhVien> listSV = svDAO.getByMaLop(ctlh.getMaLop());

        List<ChiTietMonHoc> listCTMH = new ArrayList<>();
        listSV.forEach(e -> {
            ChiTietMonHoc ctmh = new ChiTietMonHoc();
            ctmh.setMaLop(ctlh.getMaLop());
            ctmh.setMaMon(ctlh.getMaMon());
            ctmh.setMssv(e.getMssv());
            listCTMH.add(ctmh);
        });

        ctmhDAO.insertAll(listCTMH);
    }

    @Override
    public void insertAll(List<ChiTietLopHoc> ctlh) {
        ctlh.forEach(this::insert);
    }

    @Override
    public List<ChiTietLopHoc> getAll() {
        String sql = String.format("from %s", ChiTietLopHoc.class.getName());
        Query query = session.createQuery(sql);
        List<ChiTietLopHoc> result = query.getResultList();
        return result;
    }

    @Override
    public List<ChiTietLopHoc> getByMaLop(String maLop) {
        String sql = String.format("from %s sv where sv.maLop = :maLop", ChiTietLopHoc.class.getName());
        Query query = session.createQuery(sql);
        query.setParameter("maLop", maLop);
        List<ChiTietLopHoc> result = query.getResultList();
        return result;
    }
}
