import models.Animal;
import models.Place;
import models.Workman;
import models.Zoo;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.fintech.qa.homework.utils.BeforeUtils;


import javax.persistence.PersistenceException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestRecords {
    private Session session;

    @BeforeAll
    public void startUp(){
        BeforeUtils.createData();
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public void tearDown(){
        session.close();
    }

    @Test
    public void testAnimalsCount(){
        List<Animal> result = session.createNativeQuery("select * from public.animal", Animal.class).getResultList();
        Assertions.assertEquals(10, result.size());
    }

    public static List<Integer> existenceIds() {
        int numberOfRecords = 10;
        return Stream.iterate(1, n -> n + 1)
                .limit(numberOfRecords)
                .collect(Collectors.toList());
    }


    @ParameterizedTest
    @MethodSource("existenceIds")
    public void testExistenceAnimalId(int existenceId){
        Animal newAnimal = new Animal();
        newAnimal.setId(existenceId);
        newAnimal.setAge(12);
        newAnimal.setName("Vasya");
        newAnimal.setSex(1);
        newAnimal.setPlace(1);
        Transaction transaction = session.beginTransaction();
        session.save(newAnimal);
        Assertions.assertThrows(PersistenceException.class, transaction::commit);

    }

    @Test
    public void testNullNameWorkman(){
        Workman newWorkman = new Workman();
        newWorkman.setId(30);
        newWorkman.setName(null);
        newWorkman.setPosition(1);
        newWorkman.setAge(30);
        Transaction transaction = session.beginTransaction();
        session.save(newWorkman);
        Assertions.assertThrows(PersistenceException.class, transaction::commit);
    }

    @Test
    public void testAddNewPlace(){
        Place newPlace = new Place();
        newPlace.setId(6);
        newPlace.setPlace_num(12);
        newPlace.setRow(2);
        newPlace.setName("Нора");
        Transaction transaction = session.beginTransaction();
        session.save(newPlace);
        transaction.commit();
        List<Place> result = session.createNativeQuery("select * from public.places", Place.class).getResultList();
        Assertions.assertEquals(6, result.size());
    }

    @Test
    public void testZooNames(){
        List<Zoo> result = session.createNativeQuery("select * from public.zoo where \"name\" like 'Северный' " +
                "or  \"name\" like 'Западный' " +
                "or \"name\" like 'Центральный'", Zoo.class).getResultList();
        Assertions.assertEquals(3, result.size());
    }
}
