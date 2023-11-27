package com.travash.nigrani.Services;

import java.util.List;

import com.travash.nigrani.Model.SiteDetails;

public interface Sitedetailservices {

	
	public SiteDetails addSiteDetails(SiteDetails details);
	public SiteDetails updateSiteDetails(SiteDetails details,Integer siteDetailId);
	public SiteDetails deleteSiteDetails(Integer siteDetailId);
	public SiteDetails getSiteDetails(Integer siteDetailId);
	public List<SiteDetails> getAllSiteDetails();
	
}
