package cyber.hometown2.service.Impl;

import cyber.hometown2.mapper.UserInfoMapper;
import cyber.hometown2.pojo.UserInfo;
import cyber.hometown2.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoImpl implements UserInfo {
    @Autowired
    private UserInfoMapper UserInfoMapper;

    @Override
    public UserInfo getUserInfo(){
        UserInfo userInfo = UserInfoMapper.getUserInfo();
        return userInfo;
    }

}
