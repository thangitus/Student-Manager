package Data.DAO.Impl;

import Data.DAO.ChiTietMonHocDAO;
import Data.HibernateUtils;
import Data.entities.ChiTietMonHoc;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ChiTietMonHocDAOImpl implements ChiTietMonHocDAO {
    private static Session session;


    public static void setSession(Session session){
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
        String sql = String.format("from %s ctmh where ctmh.maLop = :maLop and ctmh.maMon = :maMon", ChiTietMonHoc.class.getName());
        Query query = session.createQuery(sql);
        query.setParameter("maLop", ctmh.get(0).getMaLop());
        query.setParameter("maMon", ctmh.get(0).getMaMon());
        List<ChiTietMonHoc> listCTMH = query.getResultList();
        listCTMH.forEach(e -> {
            Optional<ChiTietMonHoc> k = ctmh.stream().parallel().filter(f-> f.getMssv().equals(e.getMssv())).findAny();
            k.ifPresent(f -> updateDiem(e, f.getDiemGk(), f.getDiemCk(), f.getDiemKhac(), f.getDiemTong()));
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
        String sql = String.format("from %s ctmh where ctmh.MaLop = :maLop and ctmh.MaMon = :maMon", ChiTietMonHoc.class.getName());
        Query query = session.createQuery(sql);
        query.setParameter("maLop", maLop);
        query.setParameter("maMon", maMon);
        List<ChiTietMonHoc> result = query.getResultList();
        return result;
    }

    @Override
    public ChiTietMonHoc getByMaLopMaMonMssv(String maLop, String maMon, String mssv) {
        String sql = String.format("from %s ctmh where ctmh.MaLop = :maLop and ctmh.MaMon = :maMon and ctmh.Mssv = :mssv", ChiTietMonHoc.class.getName());
        Query query = session.createQuery(sql);
        query.setParameter("maLop", maLop);
        query.setParameter("maMon", maMon);
        query.setParameter("mssv", mssv);
        ChiTietMonHoc result = (ChiTietMonHoc) query.getSingleResult();
        return result;
    }

    @Override
    public void updateDiem(ChiTietMonHoc ctmh, Double diemGK, Double diemCK, Double diemKhac, Double diemTong) {
        ctmh.setDiemGk(diemGK);
        ctmh.setDiemCk(diemCK);
        ctmh.setDiemKhac(diemKhac);
        ctmh.setDiemTong(diemTong);
    }
}
