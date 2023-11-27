package com.travash.nigrani.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travash.nigrani.Model.Staff;


@Repository
public interface StaffRepo extends JpaRepository<Staff, Long>{

}
