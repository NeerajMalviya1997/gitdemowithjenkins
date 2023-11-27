package com.travash.nigrani.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travash.nigrani.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	public Optional<User> findByMobileNo(String mobileNo);
	public Optional<User> findById(Integer id);
}
