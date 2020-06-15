package Data;

import Data.DAO.Impl.SinhVienDAOImpl;
import Data.DAO.SinhVienDAO;
import Data.entities.SinhVien;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            session.getTransaction().begin();

            SinhVienDAOImpl.setSession(session);
            SinhVienDAO sv = new SinhVienDAOImpl();

            SinhVien sv1 = sv.getByMSSV("1712768");
            sv1.setHoVaTen("Nguyen Van B");

            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }


//    public static void main(String[] args) {
//        SessionFactory factory = HibernateUtils.getSessionFactory();
//        Session session = factory.getCurrentSession();
//
//        try{
//            session.getTransaction().begin();
//            List<SinhVien> list = new ArrayList<>();
//
//            list = DataUtils.getAll(session);
//
//            System.out.println(list);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            session.getTransaction().rollback();
//        }
//    }
}