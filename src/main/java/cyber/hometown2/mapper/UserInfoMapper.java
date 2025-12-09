package cyber.hometown2.mapper;

import cyber.hometown2.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select * from user where id = #{id}")
    UserInfo getUserById(Integer id);

    @Select("select * from user")
    List<UserInfo> getUsers();

    @Select("select * from user")
    UserInfo getUserInfo();
}