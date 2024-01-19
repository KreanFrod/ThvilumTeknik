package dk.thvilum.TT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dk.thvilum.TT.model.CustomerEntity;
import dk.thvilum.TT.repository.CustomerRepository;

@Controller
public class CustomerController {
    
    @Autowired
    private CustomerRepository cRepo;

    @GetMapping({"/kunde"})
    public ModelAndView getAllcustomers() {
        ModelAndView mav = new ModelAndView("list-customers");
        mav.addObject("customers", cRepo.findAll());
        return mav;
    }

    @GetMapping("/addCustomerForm")
    public ModelAndView addcustomerForm() {
        ModelAndView mav = new ModelAndView("add-customer-form");
            CustomerEntity newcustomer = new CustomerEntity();
            mav.addObject("customer", newcustomer);
            return mav;
    }

    @PostMapping("/saveCustomer")
    public String savecustomer(@ModelAttribute CustomerEntity customer) {
        cRepo.save(customer);
        return "redirect:/kunde";
    }

    @GetMapping("/showUpdateCustomerForm")
	public ModelAndView showUpdateForm(@RequestParam Integer customerId) {
		ModelAndView mav = new ModelAndView("add-customer-form");
		CustomerEntity customer = cRepo.findById(customerId).get();
		mav.addObject("customer", customer);
		return mav;
    }

    @GetMapping("/deletecustomer")
	public String deletecustomer(@RequestParam Integer customerId) {
		cRepo.deleteById(customerId);
		return "redirect:/kunde";
	}
}
