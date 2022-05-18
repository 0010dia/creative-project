package persistence.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class UserDTO {
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_email;
}
