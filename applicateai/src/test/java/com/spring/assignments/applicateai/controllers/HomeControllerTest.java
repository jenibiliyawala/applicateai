package com.spring.assignments.applicateai.controllers;

import com.spring.assignments.applicateai.controllers.HomeController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.spring.assignments.applicateai.testutils.Constant.ROOT_URL;
import static com.spring.assignments.applicateai.testutils.Constant.PORT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {
    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new HomeController());
    }

    @Test
    public void simpleTest() {
        given()
                .when()
                    .port(PORT)
                    .baseUri(ROOT_URL)
                    .basePath("/ping")
                    .get()
                .then()
                    .log().ifValidationFails()
                    .statusCode(200)
                    .body(is(equalTo("pong")));
    }
}