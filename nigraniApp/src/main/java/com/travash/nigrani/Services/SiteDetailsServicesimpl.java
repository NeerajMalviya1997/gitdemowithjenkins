package com.travash.nigrani.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travash.nigrani.ExceptionHandler.SiteDetailsNotFoundException;
import com.travash.nigrani.Model.SiteDetails;
import com.travash.nigrani.Repositories.Site_details_Repo;


@Service
public class SiteDetailsServicesimpl implements Sitedetailservices{
	

	
	
	@Autowired
	private Site_details_Repo site_details_Repo;

	@Override
	public SiteDetails addSiteDetails(SiteDetails siteDetails) {
	
		return site_details_Repo.save(siteDetails);
	}

	@Override
	public SiteDetails updateSiteDetails(SiteDetails details,Integer siteDetailId) {
		Optional<SiteDetails> siteDetails=site_details_Repo.findById(siteDetailId);
		if(!siteDetails.isPresent()) {
			new SiteDetailsNotFoundException("Site details not found ");
		}
		siteDetails.get().setNumberOfCameras(details.getNumberOfCameras());
		siteDetails.get().setSiteDescription(details.getSiteDescription());
		return site_details_Repo.save(details);
	}

	@Override
	public SiteDetails deleteSiteDetails(Integer siteDetailId) {
		Optional<SiteDetails> siteDetails=site_details_Repo.findById(siteDetailId);
		if(!siteDetails.isPresent()) {
			new SiteDetailsNotFoundException("Site details not found ");
		}
		
				site_details_Repo.deleteById(siteDetailId);
				return  siteDetails.get();
	}

	@Override
	public SiteDetails getSiteDetails(Integer siteDetailId) {
		System.out.println("inside get site details ");
		Optional<SiteDetails> siteDetails=site_details_Repo.findById(siteDetailId);
		if(!siteDetails.isPresent()) {
			new SiteDetailsNotFoundException("Site details not found ");
		}
		
				System.out.println(siteDetailId.toString());
		return siteDetails.get();
	}

	@Override
	public List<SiteDetails> getAllSiteDetails() {
		List<SiteDetails> SiteDetails=site_details_Repo.findAll();
		return SiteDetails;
	}

}
