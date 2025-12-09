package cyber.hometown2.service.Impl;

import cyber.hometown2.mapper.FoodMapper;
import cyber.hometown2.pojo.Food;
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

    //添加
    @Override
    public void addFood(Food food) {
        food.setCreationDate(LocalDateTime.now());
        food.setUpdateDate(LocalDateTime.now());
        foodMapper.insertFood(food);
    }

    //修改
    @Override
    public void updateFood(Food food) {
        food.setUpdateDate(LocalDateTime.now());
        foodMapper.updateFood(food);
    }

    //删除
    @Override
    public void deleteFood(Integer id) {
        foodMapper.deleteFood(id);
    }
}
