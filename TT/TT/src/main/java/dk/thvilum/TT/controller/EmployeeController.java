package dk.thvilum.TT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dk.thvilum.TT.model.UserEntity;
import dk.thvilum.TT.repository.UserRepository;

@Controller
public class EmployeeController {
    
    @Autowired
    private UserRepository eRepo;

    @GetMapping({"/userlist"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("list-employees");
        mav.addObject("employees", eRepo.findAll());
        return mav;
    }

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-employee-form");
            UserEntity newEmployee = new UserEntity();
            mav.addObject("employee", newEmployee);
            return mav;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute UserEntity employee) {
        eRepo.save(employee);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Integer employeeId) {
		ModelAndView mav = new ModelAndView("add-employee-form");
		UserEntity employee = eRepo.findById(employeeId).get();
		mav.addObject("employee", employee);
		return mav;
    }

    @GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Integer employeeId) {
		eRepo.deleteById(employeeId);
		return "redirect:/list";
	}
}
