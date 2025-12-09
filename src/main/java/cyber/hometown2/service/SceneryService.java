package cyber.hometown2.service;

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
     * 添加
     * @param s
     */
    void addScenery(Scenery s);

    /**
     * 修改
     * @param s
     */
    void updateScenery(Scenery s);

    /**
     * id删除
     * @param id
     */
    void deleteScenery(Integer id);
}
