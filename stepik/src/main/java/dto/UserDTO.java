package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    public int id;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public int userStatus;
}