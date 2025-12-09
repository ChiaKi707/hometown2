package cyber.hometown2.service;

import cyber.hometown2.pojo.UserInfo;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    UserInfo getUserById(Integer id);
    List<UserInfo> getUsers();
}
