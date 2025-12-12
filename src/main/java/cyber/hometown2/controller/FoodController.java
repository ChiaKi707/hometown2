package cyber.hometown2.controller;

import cyber.hometown2.pojo.Food;
import cyber.hometown2.pojo.Result;
import cyber.hometown2.pojo.Scenery;
import cyber.hometown2.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/{id}")
    public Result<Food> getFood(@PathVariable Integer id) {
        Food food = foodService.findById(id);
        if(food == null) {
            return Result.error(404, "未找到记录");
        }else{
            return Result.success(food);
        }
    }

    @GetMapping
    public Result<List<Food>> getAllFood() {
        List<Food> foods = foodService.findAll();
        return Result.success(foods);
    }

    @GetMapping("/search")
    public List<Food> search(
            @RequestParam(value = "name", required = false) String name) {

        // 直接调用Service层的方法，并将参数传递过去
        return foodService.serach(name);
    }

    /**
     * 新建
     * @param food
     * @return
     */
    @PostMapping
    public Result<Food> addFood(@RequestBody Food food) {
        boolean success = foodService.addFood(food);
        if(success) {
            return Result.success(food);
        }else  {
            return Result.error(500, "添加失败");
        }
    }

    @PutMapping
    public Result<Food> updateFood(@RequestBody Food food) {
        boolean success = foodService.updateFood(food);
        if(success) {
            return Result.success(food);
        }else {
            return Result.error(404, "更新失败，未找到记录");
        }
    }

    @DeleteMapping("/{id}")
    public Result<Food> deleteFood(@PathVariable Integer id) {
        boolean success = foodService.deleteFood(id);
        if(success) {
            return Result.success();
        }else {
            return Result.error(404, "删除失败，未找到记录");
        }
    }

}
