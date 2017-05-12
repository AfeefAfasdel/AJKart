package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.EmployeeDAO;
import com.niit.model.Employee;

@Controller  
public class EmployeeController {
	
	@Autowired  
	EmployeeDAO employeeDAO;
	
	
	
	 @RequestMapping("/")  
	 public ModelAndView getForm(@ModelAttribute Employee employee) {  
		 ModelAndView model=new ModelAndView("/index");
	  return new ModelAndView("index");  
	 }  
	   
	 @RequestMapping("/index")
		public String getIndexPage(@ModelAttribute Employee employee){
		 ModelAndView model=new ModelAndView("/index");
			return "index";
		}
	  
	 @RequestMapping("register")  
	 public ModelAndView registerUser(@ModelAttribute Employee employee) {  
		 employeeDAO.addEmployee(employee);  
	  return new ModelAndView("success");  
	 }  
	  
	 @RequestMapping("list")  
	 public ModelAndView getList() {  
	  List employeeList = employeeDAO.getList();  
	  return new ModelAndView("list", "employeeList", employeeList);  
	 }  
	  
	 @RequestMapping("delete")  
	 public ModelAndView deleteUser(@RequestParam int id) {  
		 employeeDAO.deleteEmployee(id);  
	  return new ModelAndView("redirect:list");  
	 }  
	  
	 @RequestMapping("edit")  
	 public ModelAndView editUser(@RequestParam int id,  
	   @ModelAttribute Employee employee) {  
	  Employee employeeObject = employeeDAO.getRowById(id);  
	  return new ModelAndView("edit", "employeeObject", employeeObject);  
	 }  
	  
	 @RequestMapping("update")  
	 public ModelAndView updateUser(@ModelAttribute Employee employee) {  
		 employeeDAO.updateEmployee(employee);  
	  return new ModelAndView("redirect:list");  
	 }  

}
