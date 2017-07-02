package com.dhakre.rohit.services;

import com.dhakre.rohit.models.User;
import com.dhakre.rohit.responses.BaseResponse;

public interface IRegistrationService {

	public BaseResponse registerUser(User user);

}
