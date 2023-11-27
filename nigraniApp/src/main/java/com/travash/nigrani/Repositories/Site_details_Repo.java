package com.travash.nigrani.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travash.nigrani.Model.SiteDetails;

@Repository
public interface Site_details_Repo extends JpaRepository<SiteDetails, Integer>{

}
