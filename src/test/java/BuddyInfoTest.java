import AddressBook.AddressBook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import AddressBook.AddressBook;
import AddressBook.BuddyInfo;

/**
 * Created by sarrankanpathmanatha on 1/12/2017.
 */
public class BuddyInfoTest {

    private BuddyInfo buddy;

    @Before
    public void setUp() throws Exception {
        buddy = new BuddyInfo("Jane","170 Blue Street");
    }

    @After
    public void tearDown() throws Exception {
        buddy = null;
        assertNull(buddy);
    }

    @Test
    public void testBuddy() throws Exception {
        assertNotNull(buddy);
    }

    @Test
    public void getName() throws Exception {
        assertEquals(buddy.getName(),"Jane");
    }

    @Test
    public void setName() throws Exception {
        buddy.setName("Zane");
        assertEquals(buddy.getName(),"Zane");
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals(buddy.getAddress(),"170 Blue Street");
    }

    @Test
    public void setAddress() throws Exception {
        buddy.setAddress("180 Red Street");
        assertEquals(buddy.getAddress(),"180 Red Street");
    }


}