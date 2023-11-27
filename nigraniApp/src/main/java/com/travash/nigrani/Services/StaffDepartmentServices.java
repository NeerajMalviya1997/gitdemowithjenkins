package com.travash.nigrani.Services;

import java.util.List;
import com.travash.nigrani.Model.StaffDepartment;

public interface StaffDepartmentServices {

	public StaffDepartment addStaffDepartment(StaffDepartment StaffDepartmentDetails);
	public StaffDepartment deleteStaffDepartment(Integer StaffDepartmentID);
	public StaffDepartment updateStaffDepartment(Integer StaffDepartmentId, StaffDepartment staffDetails);
	public StaffDepartment getStaffDepartmentByStaffDepartmentId(Integer StaffDepartmentId);
	public List<StaffDepartment> getAllStaffDepartment();
}
