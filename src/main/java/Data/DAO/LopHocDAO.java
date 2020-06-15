package Data.DAO;

import Data.entities.LopHoc;

import java.util.List;

public interface LopHocDAO {
    public void insert(LopHoc lh);
    public void insertAll (List<LopHoc> lh);

    public List<LopHoc> getAll();
}
