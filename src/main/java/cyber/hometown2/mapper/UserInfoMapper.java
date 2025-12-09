package cyber.hometown2.mapper;

import cyber.hometown2.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Select("select * from user")
    UserInfo getUserInfo();
}