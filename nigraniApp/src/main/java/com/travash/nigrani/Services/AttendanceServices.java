package com.travash.nigrani.Services;

import java.util.List;

import com.travash.nigrani.Model.Attendance;

public interface AttendanceServices {
	public Attendance addAttendance(Attendance attendance);
	public Attendance updateAttendance(Integer attendanceid,Attendance attendance)throws Exception;
    public Attendance deleteAttendance(Integer attendanceID) throws Exception;
	public Attendance getAttendance(Integer attendanceId) throws Exception;
	public List<Attendance> getAllAttendance() throws Exception;
}
