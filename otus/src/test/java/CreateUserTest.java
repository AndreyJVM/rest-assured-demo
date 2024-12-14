import dto.UserDTO;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import services.ServiceAPI;

import static org.testng.AssertJUnit.assertEquals;

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
}