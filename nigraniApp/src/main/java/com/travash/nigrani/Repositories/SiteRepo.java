package com.travash.nigrani.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travash.nigrani.Model.Site;



@Repository
public interface SiteRepo extends JpaRepository<Site, Integer> {
	
}
