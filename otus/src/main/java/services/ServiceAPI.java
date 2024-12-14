package services;

import dto.UserDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ServiceAPI {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";
    private static final String BASE_PATH = "/user";
    private RequestSpecification specification;

    public ServiceAPI() {
        specification = given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .log().all();
    }

    public ValidatableResponse createUser(UserDTO user) {
        return given(specification)
                .basePath(BASE_PATH)
                .body(user)
                .when()
                .post()
                .then()
                .log().all();
    }
}