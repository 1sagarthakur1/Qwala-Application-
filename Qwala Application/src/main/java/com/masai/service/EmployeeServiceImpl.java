package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DpartmentExecption;
import com.masai.exception.EmployeeException;
import com.masai.model.Dpartment;
import com.masai.model.Employee;
import com.masai.repository.DpartmentRepo;
import com.masai.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private DpartmentRepo dpartmentRepo;

	@Override
	public Employee forAddEmployee(Employee employee) {

		Employee emp = null;
		
		String string = employee.getDpartment().getDpname();
		
		List<Dpartment> list = dpartmentRepo.findAll();
		
		if(list.isEmpty()) {

			throw new DpartmentExecption("NO any department");
		}else {
			int count = 0;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getDpname().equals(string)) {
					count++;
				}
			}
			if(count>0) {
				if(employee != null) {
					
					List<Employee> eList = employeeRepo.findAll();
					if(list.isEmpty()) {
						Employee employee2  =	employeeRepo.save(employee);
					     if (employee2 == null) {
							throw new EmployeeException("Employee Dose not added");
						 }
					     emp = employee2;
					}
					else {
						int count2 = 0;
						for(int j=0;j<eList.size();j++){
							if(eList.get(j).getMobileNo().equals(employee.getMobileNo())) {
								count2++;
							}
						}
						if (count2>0) {
							throw new EmployeeException("This number allrady exist please Enter diffrent number");
						}else {
							Employee employee2  =	employeeRepo.save(employee);
						     if (employee2 == null) {
								throw new EmployeeException("Employee Dose not added");
							 }
						     emp = employee2;
						}
					}
				}
			}
			else {		
				throw new DpartmentExecption("This Dpartment dose not exixt");
			}
		}
		
		return emp;
	}

	@Override
	public List<Employee> forGetAllEmployee() {
		
		List<Employee> employees = employeeRepo.findAll();
		if(employees.isEmpty()) {
			throw new EmployeeException("Any employee is not there");
		}
		return employees;
	}

	@Override
	public Employee forGetAllEmployeeByNumber(String number) {
		Employee employees = employeeRepo.findByMobileNo(number);
		if(employees == null) {
			throw new EmployeeException("No any employee is there with this number");
		}
		
		return employees;
	}

	@Override
	public List<Employee> forGetAllEmployeeByDpName(String dpName) throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepo.findBydpartment_dpname(dpName);
		
		if (employees.isEmpty()) {
			throw new EmployeeException("No any employee in this dpartment");
		}
		
		return employees;
	}

	@Override
	public Employee deleteEmployee(String mobile) throws EmployeeException {
		
		Employee employee = employeeRepo.findByMobileNo(mobile);
		
		if(employee == null){
			throw new EmployeeException("No any employee is there with this number");
		}
		
		employeeRepo.delete(employee);
		
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee, String mobile) throws EmployeeException {
		Employee employee2 = employeeRepo.findByMobileNo(mobile);
		if(employee2 == null) {
			throw new EmployeeException("No any employee is there with this number");
		}
		employee2.setEmpName(employee.getEmpName());
		employee2.setEmpSalary(employee.getEmpSalary());
		employee2.setPic(employee.getPic());
		employee2.setAddress(employee.getAddress());
		employee2.setBatch(employee.getBatch());
		// TODO Auto-generated method stub
		
		Employee employee3 = employeeRepo.save(employee2);
		
		return employee3;
	}

}
