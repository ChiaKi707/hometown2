package cyber.hometown2.service;


import cyber.hometown2.pojo.Food;

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
     * 添加
     * @param food
     */
    void addFood(Food food);

    /**
     * 修改
     * @param food
     */
    void updateFood(Food food);

    /**
     * id删除
     * @param id
     */
    void deleteFood(Integer id);


}
