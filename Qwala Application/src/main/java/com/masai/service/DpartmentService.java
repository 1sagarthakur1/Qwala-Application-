package com.masai.service;

import java.util.List;

import com.masai.exception.DpartmentExecption;
import com.masai.exception.EmployeeException;
import com.masai.model.Dpartment;

public interface DpartmentService {
	
	public Dpartment forAddDpartment(Dpartment dpartment)throws DpartmentExecption;
	
	public List<Dpartment> getAllDpartment()throws DpartmentExecption;
	
	public Dpartment updateDpartment(String dpname,Dpartment dpartment) throws DpartmentExecption,EmployeeException;

	public Dpartment DeleteDpartment(String dpName) throws DpartmentExecption;
}
