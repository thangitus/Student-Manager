package Data.DAO.Impl;

import Data.DAO.LopHocDAO;
import Data.entities.LopHoc;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LopHocDAOImpl implements LopHocDAO {

    private static Session session;

    public static void setSession(Session session){
        LopHocDAOImpl.session = session;
    }

    @Override
    public void insert(LopHoc lh) {
        session.persist(lh);
    }

    @Override
    public void insertAll(List<LopHoc> lh) {
        lh.forEach(e ->{
            session.persist(e);
        });
    }

    @Override
    public List<LopHoc> getAll() {
        String sql = String.format("from %s", LopHoc.class.getName());
        Query query = session.createQuery(sql);
        List<LopHoc> result = query.getResultList();
        return result;
    }
}
