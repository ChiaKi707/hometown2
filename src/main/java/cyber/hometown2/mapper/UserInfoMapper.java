package cyber.hometown2.mapper;

import cyber.hometown2.pojo.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select * from user where id = #{id}")
    UserInfo getUserById(Integer id);

    @Select("select * from user")
    List<UserInfo> getUsers();

    @Select("select * from user where username = #{username} and password=#{password}")
    UserInfo getUserIdandPassword(UserInfo user);

    @Insert("INSERT INTO user (username, password) " +
            "VALUES( #{username}, #{password})")
    boolean insertUser(UserInfo user);

//    @Select("select * from user")
//    UserInfo getUserInfo();


}