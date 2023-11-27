package com.travash.nigrani.Services;

import com.travash.nigrani.Model.User;
import com.travash.nigrani.Model.UserDTO;

public interface UserLoginServices {

	public User createUser(User user);
	
	public User updateUser(User user, String key);
    public String logIntoAccount(UserDTO userDTO) throws Exception;
	
	public String logOutAccount(String key);
}
