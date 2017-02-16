package AddressBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AddressBookController {

    @GetMapping("/Books")
    public String addressBookForm(Model model) {
      model.addAttribute("Books", new AddressBook());
      return "Books";
    }
    @PostMapping("/Books")
    public String addressBookSubmit(@ModelAttribute AddressBook addressBook) {
        return "result";
    }

}