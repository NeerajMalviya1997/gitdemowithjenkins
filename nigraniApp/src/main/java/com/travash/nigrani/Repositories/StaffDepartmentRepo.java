package com.travash.nigrani.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travash.nigrani.Model.StaffDepartment;


@Repository
public interface StaffDepartmentRepo extends JpaRepository<StaffDepartment, Integer> {

}
