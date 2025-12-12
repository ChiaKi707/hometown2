package cyber.hometown2.service.Impl;

import cyber.hometown2.mapper.FoodMapper;
import cyber.hometown2.pojo.Food;
import cyber.hometown2.pojo.Scenery;
import cyber.hometown2.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    //单个查询
    @Override
    public Food findById(Integer id) {
        return foodMapper.getById(id);
    }

    //查询所有
    @Override
    public List<Food> findAll() {
        List<Food> list = foodMapper.findAllFood();
        return list;
    }

    @Override
    public List<Food> serach(String name) {
        Food f = new Food();
        f.setName(name);

        return foodMapper.search(f);
    }

    //添加
    @Override
    public boolean addFood(Food food) {
        food.setCreationDate(LocalDateTime.now());
        food.setUpdateDate(LocalDateTime.now());
        return foodMapper.insertFood(food) > 0;
    }

    //修改
    @Override
    public boolean updateFood(Food food) {
        food.setUpdateDate(LocalDateTime.now());
        return foodMapper.updateFood(food) > 0;
    }

    //删除
    @Override
    public boolean deleteFood(Integer id) {
        return foodMapper.deleteFood(id) > 0;
    }
}
