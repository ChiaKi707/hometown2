package cyber.hometown2.mapper;

import cyber.hometown2.pojo.Scenery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SceneryMapper {

    /**
     * 根据ID查询景点
     */
    @Select("SELECT * FROM scenery WHERE id = #{id}")
    Scenery getById(Integer id);

    /**
     * 查询所有景点
     */
    @Select("SELECT * FROM scenery")
    List<Scenery> findAllScenery();

    /**
     * 条件查询
     * @param scenery
     * @return
     */
    List<Scenery> search(Scenery scenery);

    /**
     * 新增景点
     */
    @Insert("INSERT INTO scenery(name, description, image, location, price, create_date, update_date) " +
            "VALUES(#{name}, #{description}, #{image}, #{location}, #{price}, #{createtime}, #{updatetime})")
    int insertScenery(Scenery scenery);

    /**
     * 根据ID删除景点
     */
    @Delete("DELETE FROM scenery WHERE id = #{id}")
    int deleteScenery(Integer id);

    /**
     * 修改景点
     */
    @Update("UPDATE scenery SET name=#{name}, description=#{description}, image=#{image}, " +
            "location=#{location}, price=#{price}, updatetime=#{updatetime} WHERE id=#{id}")
    int updateScenery(Scenery scenery);
}