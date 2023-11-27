package com.travash.nigrani.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travash.nigrani.ExceptionHandler.StaffNotFoundException;
import com.travash.nigrani.Model.Staff;
import com.travash.nigrani.Repositories.StaffRepo;

@Service
public class StaffServicesImpl implements StaffServices{
	
	@Autowired
	private StaffRepo staffRepo;

	@Override
	public Staff addStaff(Staff staffDetails) {
		// TODO Auto-generated method stub
		return staffRepo.save(staffDetails);
	}

	@Override
	public Staff deleteStaff(Long staffID) {
		Optional<Staff> StaffDetail =staffRepo.findById(staffID);
		if(!StaffDetail.isPresent()) {
			new StaffNotFoundException("need to pass");
		}
		
		staffRepo.deleteById(staffID);
		return StaffDetail.get();
	}

	@Override
	public Staff updateStaff(Long staffId, Staff staffDetails) {
		Optional<Staff> updateStaffDetails =staffRepo.findById(staffId);
		if(!updateStaffDetails.isPresent()) {
			new StaffNotFoundException("need to pass");
		}
		
		updateStaffDetails.get().setDescription(staffDetails.getDescription());
		updateStaffDetails.get().setName(staffDetails.getName());
		updateStaffDetails.get().setImageBase64(staffDetails.getImageBase64());
		staffRepo.save(updateStaffDetails.get());
		
		return updateStaffDetails.get();
	}

	@Override
	public Staff getStaffByStaffId(Long staffId) {
		Optional<Staff> staffDetails =staffRepo.findById(staffId);
		if(!staffDetails.isPresent()) {
			new StaffNotFoundException("need to pass");
		}
		
		return staffDetails.get();
	}

	@Override
	public List<Staff> getAllStaff() {
		 List<Staff> staffDetails =staffRepo.findAll();
			
			
			return staffDetails;
	}

}
