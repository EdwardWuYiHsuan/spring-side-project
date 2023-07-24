package com.edward.spring.controller.response;

import com.edward.spring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {

    private String userId;
    private String email;
    private String nickname;
    private String firstName;
    private String lastName;
    private String mobileNumber;

    public static UserInfoResponse valudOf(User user) {
        return UserInfoResponse.builder().userId(user.getUserId()).email(user.getEmail()).nickname(user.getNickname())
                .firstName(user.getFirstName()).lastName(user.getLastName()).mobileNumber(user.getMobileNumber()).build();
    }
}
