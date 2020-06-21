package Data.DAO;

import Data.entities.ChiTietMonHoc;

import java.util.List;

public interface ChiTietMonHocDAO {
    public void insert(ChiTietMonHoc ctmh);
    public void insertAll(List<ChiTietMonHoc> ctmh);

    public void importBangDiem(List<ChiTietMonHoc> ctmh);

    public List<ChiTietMonHoc> getAll();
    public List<ChiTietMonHoc> getByMaLopMaMon(String maLop, String maMon);
    public ChiTietMonHoc getByMaLopMaMonMssv(String maLop, String maMon, String mssv);
public  List<ChiTietMonHoc> getByMssv(String mssv);
    public void updateDiem(ChiTietMonHoc ctmh, Double DiemGK, Double DiemCK, Double DiemKhac, Double DiemTong);
    public void delete(ChiTietMonHoc ctmh);
}
