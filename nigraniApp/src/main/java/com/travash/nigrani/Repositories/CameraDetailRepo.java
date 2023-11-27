package com.travash.nigrani.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travash.nigrani.Model.CameraDetails;

@Repository
public interface CameraDetailRepo extends JpaRepository<CameraDetails, Integer>{

}
