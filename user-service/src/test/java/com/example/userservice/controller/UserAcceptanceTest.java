package com.example.userservice.controller;

import com.example.userservice.domain.User;
import com.example.userservice.dto.UserRequest;
import com.example.userservice.service.UserService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserAcceptanceTest {
    @LocalServerPort
    private int port;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void 유저_목록_조회_요청이_들어오면_유저_목록과_200_응답이_반환된다() {
        // given
        final UserRequest userRequest1 = new UserRequest("bjp1@naver.com", "1234", "bjp1");
        final UserRequest userRequest2 = new UserRequest("bjp2@naver.com", "1234", "bjp2");
        final UserRequest userRequest3 = new UserRequest("bjp3@naver.com", "1234", "bjp3");

        userService.createUser(userRequest1);
        userService.createUser(userRequest2);
        userService.createUser(userRequest3);

        // when
        final List<User> list = RestAssured.given()
                .log().all()
                .get("/users/all")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(List.class);

        // then
        assertThat(list).hasSize(3);
    }
}