package cyber.hometown2.service.Impl;

import cyber.hometown2.mapper.IUserInfoMapper;
import cyber.hometown2.pojo.UserInfo;
import cyber.hometown2.service.IUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoImpl implements IUserInfo {
    @Autowired
    private IUserInfoMapper iUserInfoMapper;

    @Override
    public UserInfo getUserInfo(){
        UserInfo userInfo = iUserInfoMapper.getUserInfo();
        return userInfo;
    }

}
