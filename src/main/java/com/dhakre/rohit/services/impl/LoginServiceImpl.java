package com.dhakre.rohit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhakre.rohit.entities.UserEntity;
import com.dhakre.rohit.models.User;
import com.dhakre.rohit.repositories.IUserRepository;
import com.dhakre.rohit.responses.BaseResponse;
import com.dhakre.rohit.services.ILoginService;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private IUserRepository loginRepo;

	@Override
	public BaseResponse validateUser(User user) {
		BaseResponse userCredentialResponse = new BaseResponse();
		List<UserEntity> userEntity = loginRepo.findUser(user.getUserName(), user.getPassword(), user.getUserType());
		if (userEntity != null && !userEntity.isEmpty()) {
			userCredentialResponse.setSuccessful(true);
			userCredentialResponse.setMessage("Successfully logged in");
		} else {
			userCredentialResponse.setSuccessful(false);
			userCredentialResponse.setMessage("Invalid username or password");
		}
		return userCredentialResponse;
	}

}
