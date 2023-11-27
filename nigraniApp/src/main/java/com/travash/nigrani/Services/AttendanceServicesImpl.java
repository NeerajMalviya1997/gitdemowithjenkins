package com.travash.nigrani.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travash.nigrani.ExceptionHandler.AttendenceNotFoundException;
import com.travash.nigrani.Model.Attendance;
import com.travash.nigrani.Repositories.AttendenceRepo;

@Service
public class AttendanceServicesImpl implements AttendanceServices {

	@Autowired
	private AttendenceRepo attendanceRepository;

	public Attendance addAttendance(Attendance attendance) {
		return attendanceRepository.save(attendance);
	}

	public Attendance updateAttendance(Integer attendanceId, Attendance attendance)  {
		Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendanceId);
		if (optionalAttendance.isPresent()) {
			attendance.setId(attendanceId);

			return attendanceRepository.save(attendance);
		} else {
			throw new AttendenceNotFoundException("Attendance not found");
		}
	}

	public Attendance deleteAttendance(Integer attendanceId)  {
		Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendanceId);
		if (optionalAttendance.isPresent()) {
			Attendance attendance = optionalAttendance.get();
			attendanceRepository.deleteById(attendanceId);
			return attendance;
		} else {
			throw new AttendenceNotFoundException("Attendance not found");
		}
	}

	public Attendance getAttendance(Integer attendanceId)  {
		Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendanceId);
		if (optionalAttendance.isPresent()) {
			return optionalAttendance.get();
		} else {
			throw new AttendenceNotFoundException("Attendance not found");
		}
	}

	public List<Attendance> getAllAttendance() {
		return attendanceRepository.findAll();
	}
}
