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

import com.travash.nigrani.Model.Attendance;
import com.travash.nigrani.Model.CameraDetails;
import com.travash.nigrani.Model.SiteDetails;
import com.travash.nigrani.Model.Staff;
import com.travash.nigrani.Services.AttendanceServicesImpl;
import com.travash.nigrani.Services.CameraDetailServicesImpl;
import com.travash.nigrani.Services.SiteDetailsServicesimpl;
import com.travash.nigrani.Services.StaffServicesImpl;

@RestController
@RequestMapping("/adminuser")
public class AdminUser {

	@Autowired
	private SiteDetailsServicesimpl siteDetailsServiceImpl;
	
	@Autowired
	private CameraDetailServicesImpl cameraDetailServicesImpl;
	
	@Autowired
	private StaffServicesImpl staffServicesImpl;
	
	@Autowired
	private AttendanceServicesImpl attendanceService;
	
	//--------------Sitedetails Controller--------------------------//

	// to add new Site
	@PostMapping("/addsitedetails")
	public ResponseEntity<SiteDetails> addSiteDetails(@RequestBody SiteDetails details) {

		SiteDetails us = siteDetailsServiceImpl.addSiteDetails(details);
		return new ResponseEntity<SiteDetails>(us, HttpStatus.ACCEPTED);
	}

	// to update Site
	@PutMapping("/updatesitedetail")
	public SiteDetails updateSiteDetails(@RequestBody SiteDetails details,
			@RequestParam(required = false) Integer siteDetailId)  {

		return siteDetailsServiceImpl.updateSiteDetails(details, siteDetailId);
	}

	// for  delete site
 	@DeleteMapping("/deleteSiteDetails")
	public SiteDetails deleteSiteDetails(@RequestParam Integer sitedetailsid)  {
		return siteDetailsServiceImpl.deleteSiteDetails(sitedetailsid);
	}
	
	
	
	// to getside detail
	@GetMapping("/getSiteDetail")
	public SiteDetails getsitedetail(@RequestParam(required = false) Integer siteDetailId)  {
		System.out.println("inside controller");
		return siteDetailsServiceImpl.getSiteDetails(siteDetailId);
	}

	// for getting alll details
	@GetMapping("/getAllSiteDetails")
	public List<SiteDetails> getAllSiteDetails()  {
		return siteDetailsServiceImpl.getAllSiteDetails();
	}
	
	
	//--------------Camera detail Controller--------------------------//
	
	@PostMapping("/addCameraDeatails")
	public ResponseEntity<CameraDetails> addCameraDeatails(@RequestBody CameraDetails cameraDetails) {

		CameraDetails  us = cameraDetailServicesImpl.addCamera(cameraDetails);
		return new ResponseEntity<CameraDetails>(us, HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteCameraDetails")
	public CameraDetails deleteCameraDetails(@RequestParam Integer cameraDetailsId)  {
		return cameraDetailServicesImpl.deleteCamera(cameraDetailsId);
	}
	
	@PutMapping("/updateCameraDetails")
	public CameraDetails updateCameraDetails(@RequestBody CameraDetails details,
			@RequestParam(required = false) Integer cameraDetailId)  {

		return cameraDetailServicesImpl.updateCamera(cameraDetailId, details);
	}
	
	// to getside detail
	@GetMapping("/getCameraDetail")
	public CameraDetails getCameraDetail(@RequestParam(required = false) Integer siteCameraId)  {
		System.out.println("inside controller");
		return cameraDetailServicesImpl.getCameraByCameraId(siteCameraId);
	}

	// for getting alll details
	@GetMapping("/getAllCameraDetails")
	public List<CameraDetails> getAllCameraDetails() {
		return cameraDetailServicesImpl.getAllCamera();
	}
	
	
	//--------------Staff Controller--------------------------//
	@PostMapping("/addStaff")
	public ResponseEntity<Staff> addStaff(@RequestBody Staff staffDetails) {
	    Staff addedStaff = staffServicesImpl.addStaff(staffDetails);
	    return new ResponseEntity<>(addedStaff, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteStaff")
	public Staff deleteStaff(@RequestParam Long staffID)  {
	    return staffServicesImpl.deleteStaff(staffID);
	}

	@PutMapping("/updateStaff")
	public Staff updateStaff(@RequestBody Staff staffDetails,
	                        @RequestParam(required = false) Long staffId)  {
	    return staffServicesImpl.updateStaff(staffId, staffDetails);
	}

	@GetMapping("/getStaffDetail")
	public Staff getStaffDetail(@RequestParam(required = false) Long staffId)  {
	    System.out.println("inside controller");
	    return staffServicesImpl.getStaffByStaffId(staffId);
	}

	@GetMapping("/getAllStaffDetails")
	public List<Staff> getAllStaffDetails() {
	    return staffServicesImpl.getAllStaff();
	}
	
	
	//--------------attendance Controller--------------------------//
	@PostMapping("/addAttendance")
    public ResponseEntity<Attendance> addAttendance(@RequestBody Attendance attendance) {
        Attendance addedAttendance = attendanceService.addAttendance(attendance);
        return new ResponseEntity<>(addedAttendance, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteAttendance")
    public ResponseEntity<Attendance> deleteAttendance(@RequestParam Integer attendanceID)   {
        Attendance deletedAttendance = attendanceService.deleteAttendance(attendanceID);
        return new ResponseEntity<>(deletedAttendance, HttpStatus.OK);
    }

    @PutMapping("/updateAttendance")
    public ResponseEntity<Attendance> updateAttendance(@RequestParam Integer attendanceId, @RequestBody Attendance attendance)  {
        Attendance updatedAttendance = attendanceService.updateAttendance(attendanceId, attendance);
        return new ResponseEntity<>(updatedAttendance, HttpStatus.OK);
    }

    @GetMapping("/getAttendanceDetail")
    public ResponseEntity<Attendance> getAttendanceDetail(@RequestParam Integer attendanceId)  {
        Attendance retrievedAttendance = attendanceService.getAttendance(attendanceId);
        return new ResponseEntity<>(retrievedAttendance, HttpStatus.OK);
    }

    @GetMapping("/getAllAttendanceDetails")
    public ResponseEntity<List<Attendance>> getAllAttendanceDetails()  {
        List<Attendance> attendanceList = attendanceService.getAllAttendance();
        return new ResponseEntity<>(attendanceList, HttpStatus.OK);
    }
}
