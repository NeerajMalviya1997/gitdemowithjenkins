package com.travash.nigrani.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travash.nigrani.ExceptionHandler.SiteNotFoundException;
import com.travash.nigrani.Model.Site;
import com.travash.nigrani.Repositories.SiteRepo;


@Service
public class SiteServicesImpl implements SiteServices{
	
	
	@Autowired
	private SiteRepo siteRepo;

	@Override
	public Site addSite(Site site) {	
		return siteRepo.save(site);
	}

	@Override
	public Site updateSite(Integer siteid,Site site) {
		Optional<Site> updateSite = siteRepo.findById(siteid);
		if(!updateSite.isPresent()) {
			throw new SiteNotFoundException("Site Id Is not present");
		}
		updateSite.get().setSiteName(site.getSiteName());
		return siteRepo.save(updateSite.get());
	}

	@Override
	public Site deleteSite(Integer siteID)  {
		Optional<Site> site = siteRepo.findById(siteID);
		if(!site.isPresent()) {
			throw new SiteNotFoundException("Site Id Is not present");
		}
		
				siteRepo.deleteById(siteID);
				return site.get();
	}

	@Override
	public Site getSite(Integer siteId)  {
		Optional<Site> site = siteRepo.findById(siteId);
		if(!site.isPresent()) {
			throw new SiteNotFoundException("Site Id Is not present");
		}
		
				
				return site.get();
		
	}

	@Override
	public List<Site> getAllSite()  {
		List<Site> sites= siteRepo.findAll();
		return sites;
	}

}
