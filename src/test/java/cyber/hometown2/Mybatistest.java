package cyber.hometown2;

import cyber.hometown2.mapper.UserInfoMapper;
import cyber.hometown2.pojo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class Mybatistest {

    @Autowired
    private UserInfoMapper UserInfoMapper;

    @Test
    public void Mybatistest1() throws Exception{
        List<UserInfo> userInfos = Collections.singletonList(UserInfoMapper.getUserInfo());
        for (UserInfo user : userInfos) {
            System.out.println(user);
        }
    }
}
