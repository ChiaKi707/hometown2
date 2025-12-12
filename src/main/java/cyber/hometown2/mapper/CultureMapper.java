package cyber.hometown2.mapper;

import cyber.hometown2.pojo.Culture;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CultureMapper {

    /**
     * 根据ID查询文化
     */
    @Select("SELECT * FROM culture WHERE id = #{id}")
    Culture getById(Integer id);

    /**
     * 查询所有文化
     */
    @Select("SELECT * FROM culture")
    List<Culture> findAllCulture();

    /**
     * 条件查询文化列表
     * 可配合 MyBatis XML 进行动态 SQL
     */
    List<Culture> search(Culture culture);

    /**
     * 新增美食
     */
    @Insert("INSERT INTO culture(name, description, image, creation_date, update_date) " +
            "VALUES(#{name}, #{description}, #{image}, #{creationDate}, #{updateDate})")
    int insertCulture(Culture culture);

    /**
     * 根据ID删除美食
     */
    @Delete("DELETE FROM culture WHERE id = #{id}")
    int deleteCulture(Integer id);

    /**
     * 修改美食
     */
    @Update("UPDATE culture SET name=#{name}, description=#{description}, image=#{image}, " +
            "update_date=#{updateDate} WHERE id=#{id}")
    int updateCulture(Culture culture);

}