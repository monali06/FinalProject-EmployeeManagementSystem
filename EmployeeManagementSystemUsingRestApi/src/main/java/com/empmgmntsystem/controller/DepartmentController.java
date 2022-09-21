package com.empmgmntsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmgmntsystem.entity.Department;
import com.empmgmntsystem.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	// displaying list of all department
	@GetMapping("/departments")
	public List<Department> getAllDepartment()
	{
		return departmentService.getAllDepartment();
	}
	
	// displaying department by id
	@GetMapping("/departments/{departmentId}")
	public Department getDepartmentById(@PathVariable int departmentId)
	{
		return departmentService.getDepartment(departmentId).get();
	}
	

	// inserting department
	@PostMapping("/departments")
	public Department addDepartment(@RequestBody Department department)
	{
		return departmentService.addDepartment(department);
	}
	
	//updating department by id
	@PutMapping("/departments/{deptid}")
	public Department updateDepartment(@PathVariable("deptid") int departmentId,@RequestBody Department department)
	{
		return departmentService.updateDepartment(departmentId,department);
	}
	
	// deleting all department
	@DeleteMapping("/departments")
	public void deleteAllDepartments()
	{
		departmentService.deleteAllDepartments();
	}

	// deleting department by id
	@DeleteMapping("/departments/{departmentId}")
	public String deleteDepartmentByID(@PathVariable int departmentId)
	{
		departmentService.deleteDepartment(departmentId);
		return "Deleted Successfully";
	}

	/*
	// updating/ patching department by id
	@PatchMapping("departments/{id}")
	public void patchDepartmentByID(@RequestBody Department department, @PathVariable int departmentId)
	{
		departmentService.patchDepartment(department, departmentId);
	}*/
	
}