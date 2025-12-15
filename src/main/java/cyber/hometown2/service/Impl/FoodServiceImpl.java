package cyber.hometown2.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cyber.hometown2.mapper.FoodMapper;
import cyber.hometown2.pojo.Food;
import cyber.hometown2.pojo.PageResult;
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
        food.setCreationTime(LocalDateTime.now());
        food.setUpdateTime(LocalDateTime.now());
        return foodMapper.insertFood(food) > 0;
    }

    //修改
    @Override
    public boolean updateFood(Food food) {
        food.setUpdateTime(LocalDateTime.now());
        return foodMapper.updateFood(food) > 0;
    }

    //删除
    @Override
    public boolean deleteFood(Integer id) {
        return foodMapper.deleteFood(id) > 0;
    }

    @Override
    public PageResult<Food> list(String name, Integer pageNum, Integer pageSize) {
        // 1. 设置分页
        PageHelper.startPage(pageNum, pageSize);

        // 2. 执行查询
        Food queryCondition = new Food();
        queryCondition.setName(name);
        List<Food> L = foodMapper.search(queryCondition);

        // 3. 封装结果
        Page<Food> p = (Page<Food>) L;
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
