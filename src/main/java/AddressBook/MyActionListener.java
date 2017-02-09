/**
 * Created by sarrankanpathmanatha on 1/26/2017.
 */


package AddressBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.List;
import javax.persistence.*;
import javax.swing.JOptionPane;
import javax.swing.*;

public class MyActionListener implements ActionListener {
    private AddressBook addressBook;
    private BuddyInfo buddy;
    private JTextField buddyName;
    private JTextField buddyAddress;
    private JTextField buddyPhone;
    private JTextField contacts;

    public void setBuddyName(JTextField name){ this.buddyName = name;}
    public void setBuddyAddress(JTextField address){this.buddyAddress = address;}
    public void setContacts(JTextField contacts){this.contacts = contacts;}

    public void actionPerformed(ActionEvent e) {

        if(addressBook == null)
        {
            addressBook = new AddressBook();
        }

        buddy = new BuddyInfo();
        buddy.setName(buddyName.getText());
        buddy.setAddress(buddyAddress.getText());

        addressBook.addBuddy(buddy);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pathSoft");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(addressBook);
        tx.commit();
        em.close();
        emf.close();

        contacts.setText(addressBook.printAddressBook());
    }
}