import dto.UserDTO;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import services.ServiceAPI;

public class CreateUserTest {

    ServiceAPI userAPI = new ServiceAPI();

    @Test
    public void createUser() {
        UserDTO userDTO = UserDTO.builder()
                .id(494)
                .userStatus(505)
                .firstName("Ivan")
                .email("example@google.com")
                .build();
        userAPI.createUser(userDTO)
                .statusCode(HttpStatus.SC_OK);
    }
}