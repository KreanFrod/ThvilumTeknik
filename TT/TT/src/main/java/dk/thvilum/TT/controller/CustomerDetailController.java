package dk.thvilum.TT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dk.thvilum.TT.model.CustomerDetailEntity;
import dk.thvilum.TT.repository.CustomerDetailRepository;

@Controller
public class CustomerDetailController {
    
    @Autowired
    private CustomerDetailRepository cRepo;

    @GetMapping("/showKundepage")
	public ModelAndView showUpdateForm(@RequestParam Integer customerId) {
		ModelAndView mav = new ModelAndView("page-customer-info");
		CustomerDetailEntity customer = cRepo.findById(customerId).get();
		mav.addObject("customer", customer);
		return mav;
    }

}
