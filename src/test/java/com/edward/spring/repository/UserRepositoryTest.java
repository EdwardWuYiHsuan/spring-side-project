package com.edward.spring.repository;

import com.edward.spring.entity.User;
import com.edward.spring.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void before() {
        log.info("== Before ==");
        userRepository.deleteAll();
    }

    @Test
    public void testCrud() {
        // Create.
        User user = userRepository.save(User.builder().userId(Utils.generateRandomDigital(36)).email("tester01@gmail.com")
                .nickname("tester-nickname").firstName("tester-firstname").lastName("tester-lastername")
                .mobileNumber("0987654321").build());
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();

        // Read.
        Optional<User> userOpt = userRepository.findById(user.getId());
        assertThat(userOpt).isNotNull();
        assertThat(userOpt.isPresent()).isTrue();

        User readUser = userOpt.get();
        assertThat(readUser.getId()).isEqualTo(user.getId());
        assertThat(readUser.getUserId()).isEqualTo(user.getUserId());
        assertThat(readUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(readUser.getNickname()).isEqualTo(user.getNickname());
        assertThat(readUser.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(readUser.getLastName()).isEqualTo(user.getLastName());
        assertThat(readUser.getMobileNumber()).isEqualTo(user.getMobileNumber());
        assertThat(user.getCreatedTime()).isNotNull();
        assertThat(user.getUpdatedTime()).isNotNull();

        // Update.
        String updatemobileNumber = "1234567890";
        readUser.setMobileNumber(updatemobileNumber);
        userRepository.save(readUser);

        List<User> userList = userRepository.findAll();
        assertThat(userList).hasSize(1);
        readUser = userList.get(0);
        assertThat(readUser.getId()).isEqualTo(user.getId());
        assertThat(readUser.getUserId()).isEqualTo(user.getUserId());
        assertThat(readUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(readUser.getNickname()).isEqualTo(user.getNickname());
        assertThat(readUser.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(readUser.getLastName()).isEqualTo(user.getLastName());
        assertThat(readUser.getMobileNumber()).isEqualTo(updatemobileNumber);
        assertThat(user.getCreatedTime()).isNotNull();
        assertThat(user.getUpdatedTime()).isNotNull();

        // Delete.
        userRepository.delete(readUser);
        assertThat(userRepository.findAll()).hasSize(0);
    }

    @Test
    public void testFindByEmail() {
        // Given.
        String userId = Utils.generateRandomDigital(36);
        String email = "tester01@gmail.com";
        String nickname = "tester-nickname";
        String firstName = "tester-firstname";
        String lastName = "tester-lastername";
        String mobileNumber = "0987654321";
        userRepository.save(User.builder().userId(userId).email(email).nickname(nickname).firstName(firstName).lastName(lastName)
                .mobileNumber(mobileNumber).build());

        // When.
        Optional<User> userOpt = userRepository.findByEmail(email);

        // Then.
        assertThat(userOpt).isNotNull();
        assertThat(userOpt.isPresent()).isTrue();
        User user = userOpt.get();
        assertThat(user.getId()).isNotNull();
        assertThat(user.getUserId()).isEqualTo(userId);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getNickname()).isEqualTo(nickname);
        assertThat(user.getFirstName()).isEqualTo(firstName);
        assertThat(user.getLastName()).isEqualTo(lastName);
        assertThat(user.getMobileNumber()).isEqualTo(mobileNumber);
        assertThat(user.getCreatedTime()).isNotNull();
        assertThat(user.getUpdatedTime()).isNotNull();

    }

    @AfterEach
    public void after() {
        log.info("== After ==");
        userRepository.deleteAll();
    }
}
