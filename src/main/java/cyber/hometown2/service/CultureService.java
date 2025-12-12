package cyber.hometown2.service;

import cyber.hometown2.pojo.Culture;
import cyber.hometown2.pojo.Food;

import java.util.List;

public interface CultureService {

    /**
     * id查询
     * @param id
     * @return
     */
    Culture findById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Culture> findAll();

    /**
     * 条件查询
     * @param name
     * @return
     */
    List<Culture> serach(String name);

    /**
     * 添加
     * @param c
     */
    boolean addCulture(Culture c);

    /**
     * 修改
     * @param c
     */
    boolean updateCulture(Culture c);

    /**
     * 删除
     * @param id
     */
    boolean deleteCulture(Integer id);
}
