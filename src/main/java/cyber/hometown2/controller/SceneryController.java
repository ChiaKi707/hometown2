package cyber.hometown2.controller;

import cyber.hometown2.pojo.PageResult;
import cyber.hometown2.pojo.Scenery;
import cyber.hometown2.pojo.Result;
import cyber.hometown2.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scenery")
public class SceneryController {

    @Autowired
    private SceneryService sceneryService;

    @GetMapping("/{id}")
    public Result<Scenery> getScenery(@PathVariable Integer id) {
        Scenery scenery = sceneryService.findById(id);
        if(scenery == null) {
            return Result.error(404, "未找到记录");
        }else{
            return Result.success(scenery);
        }
    }

    @GetMapping("/all")
    public Result<List<Scenery>> getAllScenery() {
        List<Scenery> scenerys = sceneryService.findAll();
        return Result.success(scenerys);
    }

    @GetMapping("/search")
    public List<Scenery> search(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "location", required = false) String location) {

        // 直接调用Service层的方法，并将参数传递过去
        return sceneryService.serach(name, location);
    }

    /**
     * 新建
     * @param scenery
     * @return
     */
    @PostMapping
    public Result<Scenery> addScenery(@RequestBody Scenery scenery) {
        boolean success = sceneryService.addScenery(scenery);
        if(success) {
            return Result.success(scenery);
        }else  {
            return Result.error(500, "添加失败");
        }
    }

    @PutMapping
    public Result<Scenery> updateScenery(@RequestBody Scenery scenery) {
        boolean success = sceneryService.updateScenery(scenery);
        if(success) {
            return Result.success(scenery);
        }else {
            return Result.error(404, "更新失败，未找到记录");
        }
    }

    @DeleteMapping("/{id}")
    public Result<Scenery> deleteScenery(@PathVariable Integer id) {
        boolean success = sceneryService.deleteScenery(id);
        if(success) {
            return Result.success();
        }else {
            return Result.error(404, "删除失败，未找到记录");
        }
    }

    /**
     * 统一的分页列表查询接口
     * - 不传 name: 查询所有美食（分页）
     * - 传入 name: 按名称搜索美食（分页）
     */
    @GetMapping
    public Result<PageResult<Scenery>> list(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {

        PageResult<Scenery> pageResult = sceneryService.list(name, location, pageNum, pageSize);
        return Result.success(pageResult);
    }

}


