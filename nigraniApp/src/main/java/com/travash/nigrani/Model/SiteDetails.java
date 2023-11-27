package com.travash.nigrani.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String siteDescription;

    private Integer numberOfCameras;
    
    
    @Embedded
    private SiteLocation location;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
    
    @JsonIgnore
    @OneToMany(mappedBy = "siteDetails", cascade = CascadeType.ALL)
    private List<CameraDetails> CameraDetails = new ArrayList<>();
    
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "siteDetails", cascade = CascadeType.ALL)
    private List<Staff> staff = new ArrayList<>();
    
}
