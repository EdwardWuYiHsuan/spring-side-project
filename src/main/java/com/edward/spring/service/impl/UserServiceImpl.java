package com.edward.spring.service.impl;

import com.edward.spring.controller.request.CreateOrUpdateUserRequest;
import com.edward.spring.controller.response.UserInfoResponse;
import com.edward.spring.entity.User;
import com.edward.spring.repository.UserRepository;
import com.edward.spring.service.UserService;
import com.edward.spring.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserInfoResponse> getAllUsers() {
        return userRepository.findAll().stream().map(UserInfoResponse::valudOf).collect(Collectors.toList());
    }

    @Override
    public UserInfoResponse createUser(CreateOrUpdateUserRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isPresent()) {
            return UserInfoResponse.valudOf(userOpt.get());
        }

        User user = userRepository.save(User.builder().userId(Utils.generateRandomDigital(36)).email(request.getEmail())
                .nickname(request.getNickname()).firstName(request.getFirstName()).lastName(request.getLastName())
                .mobileNumber(request.getMobileNumber()).build());
        return UserInfoResponse.valudOf(user);
    }
}
