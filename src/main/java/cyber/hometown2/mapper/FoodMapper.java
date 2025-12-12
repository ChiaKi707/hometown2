package cyber.hometown2.mapper;

import cyber.hometown2.pojo.Food;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FoodMapper {

    /**
     * 根据ID查询美食
     */
    @Select("SELECT * FROM food WHERE id = #{id}")
    Food getById(Integer id);

    /**
     * 查询所有美食
     */
    @Select("SELECT * FROM food")
    List<Food> findAllFood();

    /**
     * 条件查询美食列表
     * 可配合 MyBatis XML 进行动态 SQL
     */
    List<Food> search(Food food);

    /**
     * 新增美食
     */
    @Insert("INSERT INTO food(name, description, image, creation_date, update_date) " +
            "VALUES(#{name}, #{description}, #{image}, #{creationDate}, #{updateDate})")
    int insertFood(Food food);

    /**
     * 根据ID删除美食
     */
    @Delete("DELETE FROM food WHERE id = #{id}")
    int deleteFood(Integer id);

    /**
     * 修改美食
     */
    @Update("UPDATE food SET name=#{name}, description=#{description}, image=#{image}, " +
            "update_date=#{updateDate} WHERE id=#{id}")
    int updateFood(Food food);

}