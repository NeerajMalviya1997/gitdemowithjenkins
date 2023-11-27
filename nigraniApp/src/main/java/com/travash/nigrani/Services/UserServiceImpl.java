package com.travash.nigrani.Services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travash.nigrani.ExceptionHandler.UserNotFoundException;
import com.travash.nigrani.Model.CurrentUserSession;
import com.travash.nigrani.Model.User;
import com.travash.nigrani.Model.UserDTO;
import com.travash.nigrani.Repositories.UserRepo;
import com.travash.nigrani.Repositories.UserSessionRepo;


@Service
public class UserServiceImpl implements UserLoginServices {
	@Autowired
	private UserRepo userDao;
	
	
	@Autowired
	private UserSessionRepo userSessionDAO;
	
	@Override
	public User createUser(User user) {
		
		System.out.println("in services" + user);
		Optional<User> opt= userDao.findByMobileNo(user.getMobileNo());
		
		if(opt.isPresent()) {
//			System.out.println("User already exist");
			throw new UserNotFoundException("User already exist");
		}
	
		userDao.save(user);
		return user;
		
	}

	@Override
	public User updateUser(User user, String key) {

		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
		 
		
			if(!optCurrUser.isPresent()) {
				
				throw new UserNotFoundException("User already exist");
			}
			
			Optional<User> currentuser= userDao.findById(optCurrUser.get().getUserId());
			
			currentuser.get().setName(user.getName());
			currentuser.get().setMobileNo(user.getMobileNo());
			currentuser.get().setPassword(user.getPassword());
			currentuser.get().setEmail(user.getEmail());
			userDao.save(currentuser.get());
			return user;

	}
	
	@Override
	public String logIntoAccount(UserDTO userDTO) throws Exception {

		Optional<User> opt= userDao.findByMobileNo(userDTO.getMobileNo());
		
		if(!opt.isPresent()) {
			throw new UserNotFoundException( "Please enter valid Mobile number!");
		}
		
		User user1= opt.get();
		Integer userId = user1.getId();
		Optional<CurrentUserSession>  currUseropt1= userSessionDAO.findByUserId(userId);
		
		if(currUseropt1.isPresent()) {
			return "User already logged in with this number.";
		}
		
		if(user1.getPassword().equals(userDTO.getPassword())) {
			
			String key = UUID.randomUUID().toString();
			CurrentUserSession currentUserSession = new CurrentUserSession(userId, key, LocalDateTime.now());
			
			userSessionDAO.save(currentUserSession);

			return currentUserSession.toString();
		}
		else {
			throw new UserNotFoundException( "Please Enter valid password.");
		}

		
	}
	

	@Override
	public String logOutAccount(String key) {
		Optional<CurrentUserSession> currUserOpt=userSessionDAO.findByUuid(key);
		
		if(currUserOpt.isPresent()) {
			CurrentUserSession currUser1=currUserOpt.get();
			
			userSessionDAO.delete(currUser1);
			return "User logged out successfully.";
		}
		throw new UserNotFoundException( "User does not exist, Enter correct uuid");

	}
}
