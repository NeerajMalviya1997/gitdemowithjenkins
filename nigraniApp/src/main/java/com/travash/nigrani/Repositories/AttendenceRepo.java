 package com.travash.nigrani.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.travash.nigrani.Model.Attendance;


@Repository
public interface AttendenceRepo extends JpaRepository<Attendance, Integer>{

}
