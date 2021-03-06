import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import AddressBook.AddressBook;
import AddressBook.BuddyInfo;

public class AddressBookTest {
    private AddressBook addressBook;
    private BuddyInfo buddy;

    @Before
    public void setUp() throws Exception {
        addressBook = new AddressBook();
        buddy = new BuddyInfo("Jane","170 Blue Street","J");
    }

    @After
    public void tearDown() throws Exception {
        buddy = null;
        addressBook = null;
    }
    @Test
    public void addBuddy() throws Exception {
        addressBook.addBuddy(buddy);
        assertEquals(addressBook.containsBuddy(buddy),true);
    }

    @Test
    public void containsBuddy() throws Exception {
        addressBook.addBuddy(buddy);
        assertEquals(addressBook.containsBuddy(buddy),true);

    }


}