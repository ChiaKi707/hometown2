package cyber.hometown2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer userid;
    private String username;
    private String password;
    private String power;
    private String email;
}
