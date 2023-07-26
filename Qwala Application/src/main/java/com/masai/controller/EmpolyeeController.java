package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Employee;
import com.masai.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Employee")
public class EmpolyeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
		Employee employee2 = employeeService.forAddEmployee(employee);
		return new ResponseEntity<>(employee2, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getEmployee(){
		List<Employee> customers = employeeService.forGetAllEmployee();
		return new ResponseEntity<>(customers, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllEmployeeByNumber/{number}")
	public ResponseEntity<Employee> getEmployeeByNumber(@Valid @PathVariable("number") String string){
		Employee employee = employeeService.forGetAllEmployeeByNumber(string);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	

	@GetMapping("/getAllEmployeeByDpName/{dpartment}")
	public ResponseEntity<List<Employee>> getEmployeebydpartment(@PathVariable("dpartment") String dpname){
		List<Employee> customers = employeeService.forGetAllEmployeeByDpName(dpname);
		return new ResponseEntity<>(customers, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateEmployee/{mobile}")
	public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable("mobile") String mobile,@RequestBody Employee employee){
		Employee employee2 = employeeService.updateEmployee(employee,mobile);
		return new ResponseEntity<>(employee2, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/deleteEmployee/{mobile}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("mobile") String string){
		Employee employee = employeeService.deleteEmployee(string);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	};
}
