package com.travash.nigrani.Model;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDepartment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String DepartmentName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "staffDepartment", cascade = CascadeType.ALL)
	private List<Staff> staff = new ArrayList<>();
}
