package com.masai.model;



import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userGenerator")
    @SequenceGenerator(name = "userGenerator",sequenceName = "usergen",allocationSize = 1,initialValue = 1)
	private int empid;
	
	@NotNull(message = "Name id requid")
	@Size(min = 2,max = 15,message = "Employee name size is not good")
	private String empName;
	
	@Size(max = 150,message = "Image link is to long please give sort link")
	private String pic;
	
	@Size(min = 10,max = 10,message = "please Enter right mobile number")
	@Column(unique = true)
	private String mobileNo;
	
	
	@Max(value = 70000,message = "Employee Salary should be blow 70000")
	private int empSalary;
	
	@Embedded
	private Address address;
	
	@Enumerated(EnumType.STRING)
	private Batch batch;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="dpName")
	private Dpartment dpartment;
}
