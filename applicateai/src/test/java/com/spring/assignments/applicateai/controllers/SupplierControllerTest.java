package com.spring.assignments.applicateai.controllers;

import com.spring.assignments.applicateai.controllers.SupplierController;
import com.spring.assignments.applicateai.models.entity.Supplier;
import com.spring.assignments.applicateai.services.SupplierService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import static com.spring.assignments.applicateai.testutils.Constant.PORT;
import static com.spring.assignments.applicateai.testutils.Constant.ROOT_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.with;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

@SpringBootTest
@AutoConfigureMockMvc
public class SupplierControllerTest {
    private static final String BASE_URL = "/api/v1/suppliers";

    @Autowired
    private MockMvc mvc;

    @Mock
    SupplierService service;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new SupplierController(service));
    }

    @Test
    public void testGetAll() {
        given()
            .when()
                .port(PORT)
                .baseUri(ROOT_URL)
                .basePath(BASE_URL)
                .get()
            .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body(is(anything("name")));
    }

    @Test
    public void testGetById() {
        given()
            .when()
                .port(PORT)
                .baseUri(ROOT_URL)
                .basePath(BASE_URL)
                .get("/1")
            .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body(is(startsWith("{\"id\":1")));
    }

    @Test
    public void testGetByInvalidId() {
        given()
            .when()
                .port(PORT)
                .baseUri(ROOT_URL)
                .basePath(BASE_URL)
                .get("/100")
            .then()
                .log().ifValidationFails()
                .statusCode(404);
    }

    @Test
    public void testCreate() {
        Random random = new Random();
        int randomSku = random.nextInt(100000);

        with()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
                .body(new Supplier(1L,"xyz"))
            .when()
                .request("POST", BASE_URL)
            .then()
                .log().ifValidationFails()
                .statusCode(201);
    }
}