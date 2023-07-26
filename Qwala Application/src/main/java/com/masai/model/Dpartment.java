package com.masai.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Dpartment {
	
	@Id
	@NotNull(message = "Name id requid")
	@Size(min = 2,max = 15,message = "Employee name size is not good")
	@Column(unique = true)
	private String dpname;
	
	@NotNull(message = "Name id requid")
	private String dpIncharge;
	
	@Size(max = 150,message = "Image link is to long please give sort link")
	private String pic;
	
	@Enumerated(EnumType.STRING)
	private DpOpenClose dpOpenClose;
}
