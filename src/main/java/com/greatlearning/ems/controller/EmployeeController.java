package com.greatlearning.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;
	
	@RequestMapping("/employees/list")
	public String listofEmployees(Model model) {
		List<Employee> employees = employeeservice.list();
		model.addAttribute("employees", employees);
		return "list-employees";
	}

	@RequestMapping("/employees/showEmployeeForm_Save")
	public String saveEmployee1(Model theModel) {
	    Employee employee = new Employee();
	    theModel.addAttribute("employee", employee);
	    return "employee-form";
	}    

	
	@PostMapping("/employees/save")
	public String saveEmployee(
	    @ModelAttribute("employee") Employee employee) {
	    employeeservice.save(employee);
	    return "redirect:/employees/list";
	}

	
	@RequestMapping("/employees/showEmployeeForm_Update")
	public String updateEmployee(
	    @RequestParam("employeeId") Long employeeId,
	    Model theModel) {
	    Employee employee = employeeservice.findById(employeeId);
	    theModel.addAttribute("employee", employee);
	    return "employee-form";   
	}    


	@RequestMapping("/employees/delete")
	public String delete(
	    @RequestParam("employeeId") Long employeeId) {
	    employeeservice.deleteById(employeeId);
	    return "redirect:/employees/list";
	}  


}
