package cyber.hometown2.service;


import cyber.hometown2.pojo.Food;
import cyber.hometown2.pojo.Scenery;

import java.util.List;

public interface FoodService {

    /**
     * id查询
     * @param id
     * @return
     */
    Food findById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Food> findAll();

    /**
     * 条件查询
     * @param name
     * @return
     */
    List<Food> serach(String name);

    /**
     * 添加
     * @param food
     */
    boolean addFood(Food food);

    /**
     * 修改
     * @param food
     */
    boolean updateFood(Food food);

    /**
     * id删除
     * @param id
     */
    boolean deleteFood(Integer id);


}
