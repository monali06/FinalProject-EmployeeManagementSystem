package com.empmgmntsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empmgmntsystem.entity.Employee;
import com.empmgmntsystem.entity.Department;
import com.empmgmntsystem.service.EmployeeService;

import com.empmgmntsystem.service.DepartmentService;

@RestController
@RequestMapping("employee")
public class EmployeeController 
{

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	// displaying list of all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	
	/* 
	 @PostMapping("/addemp")
	public Employee addEmployee(@RequestBody Employee employee,@RequestParam ("deptid")int deptId) 
	{
		Department d = this.departmentService.searchById(deptId);
		employee.setDepartment(d);
		return this.employeeService.addEmployee(employee);
	
	}
	 */
	
	// displaying employee by id
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId)
	{
		return employeeService.getEmployee(employeeId).get();
	}
	
	// inserting employee
	@PostMapping("/employees")
	public Employee addEmployees(@RequestBody Employee employee,@RequestParam ("departmentid")int departmentId)
	{
		Department d=this.departmentService.searchById(departmentId);
		employee.setDepartment(d);
		return employeeService.addEmployee(employee);
	}
	
	
	
	
	//updating employee by id
	/*@PutMapping("/employees/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee e, @PathVariable int employeeId)
	{
		return employeeService.updateEmployee(e);
	}
	*/
	@PutMapping("employees/{id}")
	public Employee updateEmployee(@PathVariable("id") int employeeId, @RequestBody Employee e) 
	{
		return employeeService.updateEmployee(employeeId,e);
	}

	
	// deleting all employees
	@DeleteMapping("/employees")
	public void deleteAllEmployees()
	{
		 employeeService.deleteAllEmployees();
	}
	
	// deleting employee by id
	@DeleteMapping("employees/{employeeId}")
	public String deleteEmployeeByID(@PathVariable int employeeId)
	{
		employeeService.deleteById(employeeId);
		return "Deleted Successfully";
	}

	
	/*
	// updating/ patching employee by id
	@PatchMapping("employees/{employeeId}")
	public void patchEmployeeByID(@RequestBody Employee e, @PathVariable int employeeId) 
	{
		employeeService.patchEmployee(e, employeeId);
	}
	*/
	/*
	@GetMapping("search/{employeeFirstName}")
	public List<Employee> searchByName(@PathVariable String employeeFirstName)
	{
	   return employeeService.findByName(employeeFirstName);
	}
	
	@GetMapping("/search/{empName}")
	public List<Employee> serachName(@PathVariable("empName") String employeeFirstName){
		return this.employeeService.searchByName(employeeFirstName);
	}*/
	
}