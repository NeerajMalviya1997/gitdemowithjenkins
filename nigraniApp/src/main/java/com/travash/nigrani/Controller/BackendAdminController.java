package com.travash.nigrani.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.travash.nigrani.Model.Site;
import com.travash.nigrani.Model.StaffDepartment;
import com.travash.nigrani.Services.SiteServicesImpl;
import com.travash.nigrani.Services.StaffDepartmentServicesImpl;

@RestController
@RequestMapping("/backend/admin")
public class BackendAdminController {

	@Autowired
	private SiteServicesImpl siteServicesImpl;
	
	@Autowired
	private StaffDepartmentServicesImpl staffDepartmentServicesImpl;
	
	//-------------------------------for site----------------------------------//

	// to add new Site
	@PostMapping("/addsite")
	public ResponseEntity<Site> addsite(@RequestBody Site site) {

		Site us = siteServicesImpl.addSite(site);
		return new ResponseEntity<Site>(us, HttpStatus.ACCEPTED);
	}

	// to update Site
	@PutMapping("/updatesite")
	public Site updatesite(@RequestBody Site site, @RequestParam(required = false) Integer siteID)  {

		return siteServicesImpl.updateSite(siteID, site);
	}

	// for user login
	@DeleteMapping("/deletesite")
	public Site deletesite(@RequestParam Integer siteid)  {
		return siteServicesImpl.deleteSite(siteid);
	}
	
	
	
	
	@GetMapping("/site")
	public Site getsite(@RequestParam Integer siteid)  {
		
		return siteServicesImpl.getSite(siteid);
	}
	
	
	
	
	@GetMapping("/sites")
	public List<Site> getAllSites() throws Exception {
		return siteServicesImpl.getAllSite();
	}
	
	//---------------------for staffDepartment-------------------------//
	@PostMapping("/addStaffDepartment")
	public ResponseEntity<StaffDepartment> addStaffDepartment(@RequestBody StaffDepartment staffDepartmentDetails) {
	    StaffDepartment addedStaffDepartment = staffDepartmentServicesImpl.addStaffDepartment(staffDepartmentDetails);
	    return new ResponseEntity<>(addedStaffDepartment, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteStaffDepartment")
	public StaffDepartment deleteStaffDepartment(@RequestParam Integer staffDepartmentID)  {
	    return staffDepartmentServicesImpl.deleteStaffDepartment(staffDepartmentID);
	}

	@PutMapping("/updateStaffDepartment")
	public StaffDepartment updateStaffDepartment(@RequestBody StaffDepartment staffDepartmentDetails,
	                                            @RequestParam(required = false) Integer staffDepartmentId)  {
	    return staffDepartmentServicesImpl.updateStaffDepartment(staffDepartmentId, staffDepartmentDetails);
	}

	@GetMapping("/getStaffDepartmentDetail")
	public StaffDepartment getStaffDepartmentDetail(@RequestParam(required = false) Integer staffDepartmentId)  {
	    System.out.println("inside controller");
	    return staffDepartmentServicesImpl.getStaffDepartmentByStaffDepartmentId(staffDepartmentId);
	}

	@GetMapping("/getAllStaffDepartmentDetails")
	public List<StaffDepartment> getAllStaffDepartmentDetails()  {
	    return staffDepartmentServicesImpl.getAllStaffDepartment();
	}
	
}
