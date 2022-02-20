package web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class addressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping ("/")
    public String homepage(Model model){
        return "homepage";
    }
    @GetMapping("/book")
    public String getBuddies( Model model){
        AddressBook addressBook = addressBookRepository.findById(new Long(1)).orElse(new AddressBook("AddressBook",new Long(1)));
        model.addAttribute("addressBookName", addressBook.getName());
        model.addAttribute("buddies", addressBook.getBuddies());
        return "buddies";
    }

    @GetMapping("/add")
    public String deleteBuddy(@RequestParam(name="name", required=true) String buddy_name,@RequestParam(name="address", required=true) String buddy_address, @RequestParam(name="phonenumber", required=true) String buddy_phonenumber,  Model model){
        AddressBook book  = addressBookRepository.findById(new Long(1)).orElse(new AddressBook("AddressBook",new Long(1)));
        BuddyInfo b=new BuddyInfo(buddy_name,buddy_address,buddy_phonenumber);
        b.setAddressBook(book);
        book.addBuddy(b);
        addressBookRepository.save(book);
        model.addAttribute("addressbook", book);
        return "result";
    }

    @GetMapping("/bookform")
    public String addressBooksFrm(Model model){
        AddressBook book  = addressBookRepository.findById(new Long(1)).orElse(new AddressBook("AddressBook",new Long(1)));
        addressBookRepository.save(book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressBookForm";
    }


    @PostMapping("/bookform")
    public String addressBooksForm(@ModelAttribute BuddyInfo buddyInfo, Model model){
        AddressBook book  = addressBookRepository.findById(new Long(1)).orElse(new AddressBook("AddressBook",new Long(1)));
        buddyInfo.setAddressBook(book);
        book.addBuddy(buddyInfo);
        addressBookRepository.save(book);
        model.addAttribute("addressbook", book);
        return "result";
    }

    @GetMapping("/delete/{buddy_id}")
    public String deleteBuddy(@PathVariable Long buddy_id, Model model){
        AddressBook book  = addressBookRepository.findById(new Long(1)).orElse(new AddressBook("AddressBook",new Long(1)));
        book.removeBuddyById(buddy_id);
        addressBookRepository.save(book);
        model.addAttribute("addressbook", book);
        model.addAttribute("buddy.id", buddy_id);
        return "result";
    }


    @PostMapping("/delete/{buddy_id}")
    public String deleteBddy(@ModelAttribute AddressBook addressBook, Model model) {
        AddressBook book = addressBookRepository.findById(new Long(1)).orElse(new AddressBook("AddressBook", new Long(1)));
        model.addAttribute("addressbook", book);
        return "buddies";
    }



}
