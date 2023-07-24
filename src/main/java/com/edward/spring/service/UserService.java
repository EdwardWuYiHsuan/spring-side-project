package com.edward.spring.service;

import com.edward.spring.controller.request.CreateOrUpdateUserRequest;
import com.edward.spring.controller.response.UserInfoResponse;

import java.util.List;

public interface UserService {

    List<UserInfoResponse> getAllUsers();

    UserInfoResponse createUser(CreateOrUpdateUserRequest request);
}
