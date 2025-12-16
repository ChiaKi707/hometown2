package cyber.hometown2.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cyber.hometown2.mapper.UserInfoMapper;
import cyber.hometown2.pojo.Food;
import cyber.hometown2.pojo.PageResult;
import cyber.hometown2.pojo.UserInfo;
import cyber.hometown2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public UserInfo getUserById(Integer id) {
        return userInfoMapper.getUserById(id);
    }

    @Override
    public List<UserInfo> getUsers() {
        List<UserInfo> list = userInfoMapper.getUsers();
        return list;
    }
    @Override
    public UserInfo getUserIdandPassword(UserInfo user){
        return userInfoMapper.getUserIdandPassword(user);
    }

    @Override
    public boolean addUser(UserInfo user){
        return userInfoMapper.insertUser(user);
    }

    @Override
    public boolean updateUser(UserInfo user){return userInfoMapper.updateUser(user);}

    @Override
    public boolean changePassword(Integer userId, String oldPassword, String newPassword) {

        UserInfo user = userInfoMapper.getUserById(userId);
        if (user == null) {
//            throw new RuntimeException("用户不存在");
            return false;
        }

        if (!user.getPassword().equals(oldPassword)) {
//            throw new RuntimeException("原密码错误");
            return false;
        }

        return userInfoMapper.updatePassword(userId, newPassword);
    }

    @Override
    public List<UserInfo> search(String name) {
        UserInfo f = new UserInfo();
        f.setUsername(name);

        return userInfoMapper.search(f);
    }

    @Override
    public PageResult<UserInfo> list(String name, Integer pageNum, Integer pageSize) {
        // 1. 设置分页
        PageHelper.startPage(pageNum, pageSize);

        // 2. 执行查询
        UserInfo queryCondition = new UserInfo();
        queryCondition.setUsername(name);
        List<UserInfo> L = userInfoMapper.search(queryCondition);

        // 3. 封装结果
        Page<UserInfo> p = (Page<UserInfo>) L;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userInfoMapper.deleteUser(id);
    }

}
