package com.dhakre.rohit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhakre.rohit.entities.UserEntity;
import com.dhakre.rohit.models.User;
import com.dhakre.rohit.repositories.IUserRepository;
import com.dhakre.rohit.responses.BaseResponse;
import com.dhakre.rohit.services.IRegistrationService;

@Service("registrationService")
public class RegistrationServiceImpl implements IRegistrationService {

	@Autowired
	private IUserRepository registrationRepo;

	@Override
	public BaseResponse registerUser(User user) {
		BaseResponse userCredentialResponse = new BaseResponse();
		try {
			UserEntity userEntity = new UserEntity(0, user.getUserName(), user.getPassword(), user.getUserType());
			userEntity = registrationRepo.save(userEntity);
			user.setId(userEntity.getId());
			userCredentialResponse.setSuccessful(true);
			userCredentialResponse.setMessage("Congratulations! you are successfully registered");
			return userCredentialResponse;
		} catch (Exception e) {
			userCredentialResponse.setSuccessful(false);
			userCredentialResponse.setMessage("User already exists");
			return userCredentialResponse;
		}
	}
}
