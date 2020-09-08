package tacocloud.tacocloud.dto;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacocloud.tacocloud.entity.User;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder encoder){
        return new User(username, encoder.encode(password), fullName, street, city, state, zip, phone);
    }
}
