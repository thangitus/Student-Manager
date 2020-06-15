package Data.DAO;

import Data.entities.ChiTietLopHoc;

import java.util.List;

public interface ChiTietLopHocDAO {
    public void insert(ChiTietLopHoc ctlh);
    public void insertAll(List<ChiTietLopHoc> ctlh);

    public List<ChiTietLopHoc> getAll();
    public List<ChiTietLopHoc> getByMaLop(String maLop);
}
