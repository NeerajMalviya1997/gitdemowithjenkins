package com.travash.nigrani.Services;

import java.util.List;
import com.travash.nigrani.Model.Staff;

public interface StaffServices {


	public Staff addStaff(Staff staffDetails);
	public Staff deleteStaff(Long staffID);
	public Staff updateStaff(Long staffId, Staff staffDetails);
	public Staff getStaffByStaffId(Long staffId);
	public List<Staff> getAllStaff();
	
}
