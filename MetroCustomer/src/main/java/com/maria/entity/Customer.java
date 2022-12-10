package com.maria.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	private int customerId;
	private String customerFirstName;
	private String customerSurname;
	private String customerEmail;
	private LocalDate customerDateOfBirth;
	private double customerBalance;
	private int stationId;
}
