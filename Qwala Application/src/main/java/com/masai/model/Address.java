package com.masai.model;

import jakarta.validation.constraints.Size;

public class Address {
	
	@Size(max = 20,message = "City name is to long")
	public String city;
	@Size(max = 20,message = "State name is to long")
	public String state;
	@Size(max = 20,message = "country name is to long")
	public String country;
}
