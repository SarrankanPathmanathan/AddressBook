
import AddressBook.Application;
import AddressBook.AddressBook;
import AddressBook.BuddyInfo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringMVCTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {

        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void addBuddy() throws Exception {
        BuddyInfo buddy = new BuddyInfo("Sarran","111 Street","SP");
        ResponseEntity<String> response = template.postForEntity(base.toString()+"/buddies",buddy,String.class);
        assertThat(response.getStatusCode(),equalTo(HttpStatus.CREATED));
    }

    @Test
    public void deleteBuddy() throws Exception {
         template.delete(base.toString()+ "/buddies/1/");
         ResponseEntity<String> response = template.getForEntity(base.toString()+"/buddies/1",String.class);
        assertThat(response.getStatusCode(),equalTo(HttpStatus.NOT_FOUND));
    }

    @Test
    public void addBuddyToAddressBook() throws Exception{
        AddressBook addressBook = new AddressBook();
        ResponseEntity<String> response = template.postForEntity(base.toString()+"/Books",addressBook,String.class);
        assertThat(response.getStatusCode(),equalTo(HttpStatus.CREATED));

        BuddyInfo buddy = new BuddyInfo("Sarran","111 Street","SP");
        ResponseEntity<String> response2 = template.postForEntity(base.toString()+"/Books",buddy,String.class);
        assertThat(response2.getStatusCode(),equalTo(HttpStatus.CREATED));
    }

    @Test
    public void deleteBuddyFromAddressBook() throws Exception{
        template.delete(base.toString()+ "/Books/1/");
        ResponseEntity<String> response = template.getForEntity(base.toString()+"/Books/1",String.class);
        assertThat(response.getStatusCode(),equalTo(HttpStatus.NOT_FOUND));
    }

    @Test
    public void checkAddedAttributeNickname() throws Exception{
        BuddyInfo buddy = new BuddyInfo("JayRudra","111 Street","Jey");
        assertEquals(buddy.getNickname(),"Jey");
        ResponseEntity<String> response2 = template.postForEntity(base.toString()+"/Books",buddy,String.class);
        assertThat(response2.getStatusCode(),equalTo(HttpStatus.CREATED));




    }


}
