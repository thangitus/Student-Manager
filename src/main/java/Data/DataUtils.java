package Data;

import Data.entities.SinhVien;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DataUtils {
    private static Session session;

    public static void setSession(Session session) {
        DataUtils.session = session;
    }

    static class SinhVienHelper {
        public static SinhVien create(String mssv, String hoVaTen, String gioiTinh, String cmnd, String maLop){
            SinhVien sv = new SinhVien();
            sv.setMssv(mssv);
            sv.setHoVaTen(hoVaTen);
            sv.setGioiTinh(gioiTinh);
            sv.setCmnd(cmnd);
            sv.setMaLop(maLop);
            return sv;
        }
   
        public static List<SinhVien> getAll(Session session){
            String sql = String.format("Select s from %s s", SinhVien.class.getName());
            Query<SinhVien> query = session.createQuery(sql);
            return query.getResultList();
        }
    }
}
