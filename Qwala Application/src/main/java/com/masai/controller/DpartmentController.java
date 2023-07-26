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

import com.masai.model.Dpartment;
import com.masai.service.DpartmentService;
import com.masai.service.DpartmentServiceImpl;

import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Dpartment")
public class DpartmentController {
	
	@Autowired
	private DpartmentService dpartmentService;
	
	@Autowired
	private DpartmentServiceImpl dpartmentServiceImpl;
	
	@PostMapping("/addDpartment")
	public ResponseEntity<Dpartment> addDpartment(@Valid @RequestBody Dpartment dpartment){
		Dpartment dpartment2 = dpartmentService.forAddDpartment(dpartment);
		return new ResponseEntity<>(dpartment2,HttpStatus.CREATED);
	};
	
	@PutMapping("/updateDpartment/{dpname}")
	public ResponseEntity<Dpartment> updateDpartment(@Valid @PathVariable("dpname") String dpname,@RequestBody Dpartment dpartment){
		Dpartment dpartment2 = dpartmentService.updateDpartment(dpname,dpartment);
		return new ResponseEntity<>(dpartment2,HttpStatus.OK);
	};
//	
	@GetMapping("/getAllDpartment")
	public ResponseEntity<List<Dpartment>> getAllDpartment(){
		List<Dpartment> dpartment = dpartmentServiceImpl.getAllDpartment();
		return new ResponseEntity<>(dpartment,HttpStatus.OK);
	};
//	
	@DeleteMapping("/deleteDpartment/{dpName}")
	public ResponseEntity<Dpartment> DeleteDepartment(@PathVariable("dpName") String string){
		Dpartment dpartment = dpartmentServiceImpl.DeleteDpartment(string);
		return new ResponseEntity<>(dpartment,HttpStatus.OK);
	};
}
