package cyber.hometown2;

import cyber.hometown2.mapper.UserInfoMapper;
import cyber.hometown2.pojo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class Hometown2ApplicationTests {

    @Autowired
    private UserInfoMapper UserInfoMapper;


    @Test
    void contextLoads() throws Exception {
        List<UserInfo> userInfos = UserInfoMapper.getUsers();
        for (UserInfo user : userInfos) {
            System.out.println(user);
        }
    }

}
