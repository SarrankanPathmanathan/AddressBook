package AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressBookController {


    @Autowired
    BuddyInfoRepository brepository;

    @Autowired
    AddressBookRepository arepository;

    @GetMapping("/")
    public String greetingForm(Model model) {
       model.addAttribute("books", new AddressBook());
        model.addAttribute("buddy", new BuddyInfo());
        model.addAttribute("buddies", brepository.findAll());
        model.addAttribute("addressbooks", arepository.findAll());
        return "books";
    }

    @PostMapping("/")
    public String addressBookSubmit(@ModelAttribute("buddy") BuddyInfo buddy, @ModelAttribute("book") AddressBook book) {
        arepository.save(book);
        brepository.save(buddy);
        return "result";
    }


}
