package com.travash.nigrani.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travash.nigrani.Model.CurrentUserSession;

@Repository
public interface UserSessionRepo extends JpaRepository<CurrentUserSession, Integer> {
	
     public Optional<CurrentUserSession> findByUserId(Integer userId);
	public Optional<CurrentUserSession> findByUuid(String uuid);
}
