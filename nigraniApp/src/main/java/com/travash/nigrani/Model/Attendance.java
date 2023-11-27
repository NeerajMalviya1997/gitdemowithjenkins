package com.travash.nigrani.Model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String date;

	private boolean isPresent;
	private LocalTime inTime;
	
	private LocalTime outTime;
	
	private double totalHours;
	
	
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
}
