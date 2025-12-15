package cyber.hometown2.mapper;

import cyber.hometown2.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select * from user where userid = #{id}")
    UserInfo getUserById(Integer id);

    @Select("select * from user")
    List<UserInfo> getUsers();

    @Select("select * from user where username = #{username} and password=#{password}")
    UserInfo getUserIdandPassword(UserInfo user);

    @Insert("INSERT INTO user (username, password) " +
            "VALUES( #{username}, #{password})")
    boolean insertUser(UserInfo user);

    @Update("UPDATE user SET username=#{username}, email=#{email} " +
            "where userid=#{userid}")
    boolean updateUser(UserInfo user);

    @Update("update user set password = #{newPassword} where userid = #{userId}")
    boolean updatePassword(@Param("userId") Integer userId,
                       @Param("newPassword") String newPassword);



//    @Select("select * from user")
//    UserInfo getUserInfo();


}