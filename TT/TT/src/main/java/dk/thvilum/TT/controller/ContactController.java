package dk.thvilum.TT.controller;
import dk.thvilum.TT.model.ContactEntity;
import dk.thvilum.TT.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    
    @Autowired
    private ContactRepository cRepo;

    @GetMapping({"/kunde/kontakt"})
    public ModelAndView getAllcontacts() {
        ModelAndView mav = new ModelAndView("list-contacts");
        mav.addObject("contacts", cRepo.findAll());
        return mav;
    }

    @GetMapping("/addcontactForm")
    public ModelAndView addContactForm() {
        ModelAndView mav = new ModelAndView("add-contact-form");
            ContactEntity newcontact = new ContactEntity();
            mav.addObject("contact", newcontact);
            return mav;
    }

    @PostMapping("/savecontact")
    public String savecontact(@ModelAttribute ContactEntity contact) {
        cRepo.save(contact);
        return "redirect:/kunde";
    }

    @GetMapping("/showUpdatecontactForm")
	public ModelAndView showUpdateForm(@RequestParam Integer contactId) {
		ModelAndView mav = new ModelAndView("add-contact-form");
		ContactEntity contact = cRepo.findById(contactId).get();
		mav.addObject("contact", contact);
		return mav;
    }

    @GetMapping("/deletecontact")
	public String deletecontact(@RequestParam Integer contactId) {
		cRepo.deleteById(contactId);
		return "redirect:/kunde";
	}
}