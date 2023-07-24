package com.edward.spring.controller;

import com.edward.spring.controller.request.CreateOrUpdateUserRequest;
import com.edward.spring.controller.response.RestApiResponse;
import com.edward.spring.controller.response.UserInfoResponse;
import com.edward.spring.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user/v1/spring_test/user", produces = MediaType.APPLICATION_JSON_VALUE)  // path : /{user、internal、cms}/{version}/{module}/{controller}.
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "List All Users")
    public RestApiResponse<List<UserInfoResponse>> getAllUsers() {
        return RestApiResponse.success(userService.getAllUsers());
    }

    @PostMapping
    @Operation(summary = "Create a new User")
    public RestApiResponse<UserInfoResponse> createUser(@RequestBody CreateOrUpdateUserRequest request) {
        return RestApiResponse.success(userService.createUser(request));
    }
}
