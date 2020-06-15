package Data.DAO;

import Data.entities.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    public List<SinhVien> getAll();
    public List<SinhVien> getByMaLop(String maLop);
    public SinhVien getByMSSV(String mssv);

    public void insert(SinhVien sv);
    public void insertAll(List<SinhVien> sv);
}
