package com.masai.service;

import java.util.List;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeService {
	public Employee forAddEmployee(Employee employee) throws EmployeeException;
	
	public List<Employee> forGetAllEmployee() throws EmployeeException;
	
	public List<Employee> forGetAllEmployeeByDpName(String dpName) throws EmployeeException;
	
	public Employee forGetAllEmployeeByNumber(String name) throws EmployeeException;
	
	public Employee deleteEmployee(String mobile)throws EmployeeException;
	
	public Employee updateEmployee(Employee employee,String mobile)throws EmployeeException;
}
