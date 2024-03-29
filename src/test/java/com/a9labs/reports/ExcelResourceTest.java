package com.a9labs.reports;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExcelResourceTest {

    @Test
    public void testHelloEndpoint() {
        given().when().get("/download").then().statusCode(200).body(is("hello"));
    }

}