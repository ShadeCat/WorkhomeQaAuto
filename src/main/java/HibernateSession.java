import models.Animal;
import models.Place;
import models.Workman;
import models.Zoo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSession {
    public static SessionFactory sessionFactory = null;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildNewSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory buildNewSessionFactory() {
            return new Configuration()
                    .configure()
                    .addAnnotatedClass(Animal.class)
                    .addAnnotatedClass(Workman.class)
                    .addAnnotatedClass(Place.class)
                    .addAnnotatedClass(Zoo.class)
                    .buildSessionFactory();
        }
}
