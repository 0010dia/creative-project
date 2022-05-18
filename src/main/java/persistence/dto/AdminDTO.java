package persistence.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Builder

public class AdminDTO {
    private String user_id;
    private String admin_password;
    private String admin_name;
}
