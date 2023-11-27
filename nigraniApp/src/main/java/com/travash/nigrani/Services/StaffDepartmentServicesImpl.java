package com.travash.nigrani.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travash.nigrani.ExceptionHandler.StaffDepartmentNotFoundException;
import com.travash.nigrani.Model.StaffDepartment;
import com.travash.nigrani.Repositories.StaffDepartmentRepo;


@Service
public class StaffDepartmentServicesImpl implements StaffDepartmentServices {

	@Autowired
	private StaffDepartmentRepo staffDepartmentRepo;

	@Override
	public StaffDepartment addStaffDepartment(StaffDepartment StaffDepartmentDetails) {
		// TODO Auto-generated method stub
		throw new StaffDepartmentNotFoundException("Staff Department not found");
	}

	@Override
	public StaffDepartment deleteStaffDepartment(Integer staffDepartmentID) {
		Optional<StaffDepartment> staffDepartmentDetail = staffDepartmentRepo.findById(staffDepartmentID);
		if (!staffDepartmentDetail.isPresent()) {
			throw new StaffDepartmentNotFoundException("Staff Department not found"); // Throw an exception when not found.
		}

		staffDepartmentRepo.deleteById(staffDepartmentID);
		return staffDepartmentDetail.get();
	}

	@Override
	public StaffDepartment updateStaffDepartment(Integer staffDepartmentId, StaffDepartment staffDepartmentDetails) {
		Optional<StaffDepartment> updateStaffDepartmentDetails = staffDepartmentRepo.findById(staffDepartmentId);
		if (!updateStaffDepartmentDetails.isPresent()) {
			throw new StaffDepartmentNotFoundException("Staff Department not found"); // Throw an exception when not found.
		}

		// Update the properties of the StaffDepartment entity.
		updateStaffDepartmentDetails.get().setDepartmentName(staffDepartmentDetails.getDepartmentName());

		staffDepartmentRepo.save(updateStaffDepartmentDetails.get());

		return updateStaffDepartmentDetails.get();
	}

	@Override
	public StaffDepartment getStaffDepartmentByStaffDepartmentId(Integer staffDepartmentId) {
		Optional<StaffDepartment> staffDepartmentDetails = staffDepartmentRepo.findById(staffDepartmentId);
		if (!staffDepartmentDetails.isPresent()) {
			throw new StaffDepartmentNotFoundException("Staff Department not found"); // Throw an exception when not found.
		}

		return staffDepartmentDetails.get();
	}

	@Override
	public List<StaffDepartment> getAllStaffDepartment() {
		List<StaffDepartment> staffDepartmentDetails = staffDepartmentRepo.findAll();
		return staffDepartmentDetails;
	}

}
