package com.example.timesheet.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;
    private LocalDate date;
    private int hoursWorked;
    private String description;
	public Long getId() {
		return id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public LocalDate getDate() {
		return date;
	}
	public int getHoursWorked() {
		return hoursWorked;
	}
	public String getDescription() {
		return description;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
	public void setDate(LocalDate now) {
		// TODO Auto-generated method stub
		
	}

   
}
