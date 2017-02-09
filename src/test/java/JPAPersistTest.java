/**
 * Created by sarrankanpathmanatha on 1/19/2017.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import AddressBook.BuddyInfo;
import AddressBook.AddressBook;


import javax.persistence.*;
import java.util.List;

public class JPAPersistTest {
    private AddressBook addressBook;
    private BuddyInfo buddy1;
    private BuddyInfo  buddy2;


    @Before
    public void setUp() throws Exception {

        buddy1 = new BuddyInfo();
        buddy1.setId(1);
        buddy1.setName("Dan");
        buddy1.setAddress("C.D Howe");

        buddy2 = new BuddyInfo();
        buddy2.setId(2);
        buddy2.setName("Pat");
        buddy2.setAddress("Industry");

        addressBook = new AddressBook();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void TestPersistBuddies() throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pathSoft");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddy1);
        em.persist(buddy2);
        tx.commit();

        Query q = em.createQuery("Select b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        assert(results.contains(buddy2));
        assert(results.contains(buddy1));

        em.close();

        emf.close();

    }

    @Test
    public void TestPersistAddressBook() throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pathSoft");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddy1);
        em.persist(buddy2);
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        em.persist(addressBook);
        tx.commit();

        Query q = em.createQuery("Select b FROM AddressBook b");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        assert(results.get(0).containsBuddy(buddy1));
        assert(results.get(0).containsBuddy(buddy2));

        // Closing connection
        em.close();

        emf.close();

    }

    @Test
    public void TestPersistCascadeAddressBook() throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pathSoft");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        em.persist(addressBook);
        tx.commit();

        Query q = em.createQuery("Select b FROM AddressBook b");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        assert(results.get(0).containsBuddy(buddy1));
        assert(results.get(0).containsBuddy(buddy2));

        // Closing connection
        em.close();

        emf.close();

    }




}
