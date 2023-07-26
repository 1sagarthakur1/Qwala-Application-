package com.masai.service;

import java.util.List;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DpartmentExecption;
import com.masai.exception.EmployeeException;
import com.masai.model.Dpartment;
import com.masai.model.Employee;
import com.masai.repository.DpartmentRepo;
import com.masai.repository.EmployeeRepo;

@Service
public class DpartmentServiceImpl implements DpartmentService {
	
	@Autowired
	private DpartmentRepo dpartmentRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Dpartment forAddDpartment(Dpartment dpartment) throws DpartmentExecption {
		Dpartment dpartment2 = null;
		// TODO Auto-generated method stub
		if(dpartment != null) {
			List<Dpartment> listdList = dpartmentRepo.findAll();
			dpartment.setDpname(dpartment.getDpname().toUpperCase());
			
			int count = 0;
			for(int i=0;i<listdList.size();i++) {
				if(listdList.get(i).getDpname().equals(dpartment.getDpname())) {
					count++;
				}
			}
			if(count>0) {
				throw new DpartmentExecption("This dpartment allrady exist");
			}else {
				dpartment2 = dpartmentRepo.save(dpartment);
			}
		}
		else {
			throw new DpartmentExecption("Dpartment dose not add");
		}
		return dpartment2;
	}

	@Override
	public Dpartment updateDpartment(String dpname,Dpartment dpartment)throws DpartmentExecption,EmployeeException {
		// TODO Auto-generated method stub
		
		Dpartment dpartment2 = dpartmentRepo.findByDpname(dpname);
		
		if(dpartment2 == null) {
			throw new DpartmentExecption("No any dpartment is there with this name");
		}
		dpartment2.setDpIncharge(dpartment.getDpIncharge());
		dpartment2.setPic(dpartment.getPic());
		dpartment2.setDpOpenClose(dpartment.getDpOpenClose());
		
		Dpartment dpartment3 = dpartmentRepo.save(dpartment2);
        
		return dpartment3;
	}

	@Override
	public List<Dpartment> getAllDpartment()throws DpartmentExecption{
		
		List<Dpartment>  listdDpartments = dpartmentRepo.findAll();
		
		if (listdDpartments.isEmpty()) {
			throw new DpartmentExecption("No any DpartMent");
		}
		
		return listdDpartments;
	}

	@Override
	public Dpartment DeleteDpartment(String dpName) throws DpartmentExecption {
		
		Dpartment dpartment = dpartmentRepo.findByDpname(dpName);
		
		
		if (dpartment == null) {
			throw new DpartmentExecption("Dpartment Dose not exixt");
		}
		
        List<Employee> employees = employeeRepo.findBydpartment_dpname(dpName);
		
		if (!employees.isEmpty()) {
			throw new EmployeeException("First, remove all employees of it department");
		}
		
		dpartmentRepo.delete(dpartment);
		
		return dpartment;
	};
}
