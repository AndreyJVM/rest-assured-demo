
import dto.ResponseCreateUser;
import dto.UserDTO;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import services.ServiceAPI;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CreateUserTest {

    ServiceAPI userAPI = new ServiceAPI();

    @Test
    public void createUserAssertSC_OK() {
        UserDTO userDTO = UserDTO.builder()
                .id(494)
                .userStatus(505)
                .firstName("Ivan")
                .email("example@google.com")
                .build();
        userAPI.createUser(userDTO)
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void createUserValidateResponseMessageWithJsonPath() {
        UserDTO userDTO = UserDTO.builder()
                .id(494)
                .userStatus(505)
                .firstName("Ivan")
                .email("example@google.com")
                .build();

        ValidatableResponse response = userAPI.createUser(userDTO);

        String actualMessage = response.extract().jsonPath().get("message").toString();

        assertEquals("494", actualMessage);

    }

    @Test
    public void createUserValidateResponseWithDTO() {
        UserDTO userDTO = UserDTO.builder()
                .id(494)
                .userStatus(505)
                .firstName("Ivan")
                .email("example@google.com")
                .build();

        ValidatableResponse response = userAPI.createUser(userDTO);

        ResponseCreateUser actualUser = response.extract().body().as(ResponseCreateUser.class);
        String expected = String.valueOf(userDTO.getId());

        assertAll("Check create user response",
                () -> assertEquals(expected, actualUser.getMessage()),
                () -> assertEquals(200, actualUser.getCode()),
                () -> assertEquals("unknown", actualUser.getType())
        );
    }

    @Test
    public void createUserValidateResponseWithJsonSchemaValidator() {
        UserDTO userDTO = UserDTO.builder()
                .id(494)
                .userStatus(505)
                .firstName("Ivan")
                .email("example@google.com")
                .build();

        userAPI.createUser(userDTO)
                .statusCode(HttpStatus.SC_OK)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("494"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/userResponse.json"));

    }
}