package cyber.hometown2.DTO;

import lombok.Data;

@Data
public class ChangePasswordDTO {

    private Integer userId;
    private String oldPassword;
    private String newPassword;

}
