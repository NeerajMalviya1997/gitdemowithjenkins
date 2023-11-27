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
public class Site {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String siteName;

	@JsonIgnore
	@OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
	private List<SiteDetails> siteDetails = new ArrayList<>();

}
