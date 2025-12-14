package cyber.hometown2.service;

import cyber.hometown2.pojo.PageResult;
import cyber.hometown2.pojo.Scenery;

import java.util.List;

public interface SceneryService {

    /**
     * id查询
     * @param id
     * @return
     */
    Scenery findById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Scenery> findAll();

    /**
     * 条件查询
     * @param name
     * @param location
     * @return
     */
    List<Scenery> serach(String name, String location);

    /**
     * 添加
     * @param s
     */
    boolean addScenery(Scenery s);

    /**
     * 修改
     * @param s
     */
    boolean updateScenery(Scenery s);

    /**
     * id删除
     * @param id
     */
    boolean deleteScenery(Integer id);

    /**
     * 分页查询
     * @param name
     * @param location
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult<Scenery> list(String name,String location, Integer pageNum, Integer pageSize);

}
