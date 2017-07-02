package com.dhakre.rohit.services;

import com.dhakre.rohit.models.User;
import com.dhakre.rohit.responses.BaseResponse;

public interface ILoginService {

	public BaseResponse validateUser(User user);

}
