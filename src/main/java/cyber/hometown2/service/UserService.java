package cyber.hometown2.service;

import cyber.hometown2.pojo.PageResult;
import cyber.hometown2.pojo.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 查询id是否存在
     * @param id
     * @return
     */
    UserInfo getUserById(Integer id);

    /**
     * 返回所有用户信息
     * @return
     */
    List<UserInfo> getUsers();

    List<UserInfo> search(String name);

    /**
     * 登录检查函数，查询是否有对应用户名+密码的用户
     * @param user
     * @return
     */
    UserInfo getUserIdandPassword(UserInfo user);

    /**
     * 新增用户，用于注册功能
     * @param user
     * @return
     */
    boolean addUser(UserInfo user);

    /**
     * 修改用户名与密码
     * @param user
     * @return
     */
    boolean updateUser(UserInfo user);

    /**
     * 修改密码
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    boolean changePassword(Integer userId, String oldPassword, String newPassword);

    /**
     * 分页查询
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult<UserInfo> list(String name, Integer pageNum, Integer pageSize);

    /**
     *删除用户
     * @param id
     * @return
     */
    boolean deleteUser(Integer id);
}
