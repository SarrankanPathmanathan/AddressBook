/**
 * Created by sarrankanpathmanatha on 1/12/2017.
 */

package AddressBook;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;


@Entity
public class AddressBook extends Observable {

    private Integer id;
    private Collection<BuddyInfo> buddies;

    public AddressBook()
    {
        buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy)
    {
        buddies.add(buddy);
    }

    public boolean containsBuddy(BuddyInfo buddy)
    {
        for (BuddyInfo bud : buddies)
        {
            if (bud.getName().equals(buddy.getName()) &&  bud.getAddress().equals(buddy.getAddress()));
            {
                return true;
            }
        }

        return false;
    }

    @Id
    @GeneratedValue
    public Integer getId(){ return this.id;}

    public void setId(Integer id){ this.id = id;}


    public String printAddressBook() {
        String listofBuddies = "";
        System.out.println ("Name    Street     Phone Number \n");

        for (BuddyInfo buddy : buddies)
        {
            listofBuddies = listofBuddies + buddy.getName() + "  " + buddy.getAddress() + " " + "\n";
        }

        return listofBuddies;
    }

    @OneToMany(cascade= CascadeType.ALL)
    public Collection<BuddyInfo> getBuddies()
    {
        return buddies;
    }

    public void setBuddies(Collection<BuddyInfo> buddies)
    {
        this.buddies = buddies;
    }



}


