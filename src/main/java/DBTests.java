import models.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.fintech.qa.homework.utils.BeforeUtils;

import java.util.List;

public class DBTests {
    public static void main(String[] args) {
        BeforeUtils.createData();
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Animal> result = session.createNativeQuery("select * from public.animal", Animal.class).getResultList();
        System.out.println(result);
    }
}
