package com.travash.nigrani.Services;

import java.util.List;

import com.travash.nigrani.Model.Site;



public interface SiteServices {

	
	public Site addSite(Site site);
	public Site updateSite(Integer siteid,Site site)throws Exception;
    public Site deleteSite(Integer siteID) throws Exception;
	public Site getSite(Integer siteId) throws Exception;
	public List<Site> getAllSite() throws Exception;
	
}
