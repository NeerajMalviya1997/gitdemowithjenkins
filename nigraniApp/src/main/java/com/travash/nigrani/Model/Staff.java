package com.travash.nigrani.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	@Lob
	private String imageBase64;

	@ManyToOne
	@JoinColumn(name = "staffDepartment_id")
	private StaffDepartment staffDepartment;

	@ManyToOne
	@JoinColumn(name = "siteDetails_id")
	private SiteDetails siteDetails;
	
	
	   @JsonIgnore
	    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
	    private List<Attendance> attendances = new ArrayList<>();
}
