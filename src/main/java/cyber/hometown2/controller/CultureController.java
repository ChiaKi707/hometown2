package cyber.hometown2.controller;

import cyber.hometown2.pojo.Culture;
import cyber.hometown2.pojo.PageResult;
import cyber.hometown2.pojo.Result;
import cyber.hometown2.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/culture")
public class CultureController {

    @Autowired
    private CultureService cultureService;

    @GetMapping("/{id}")
    public Result<Culture> getCulture(@PathVariable Integer id) {
        Culture culture = cultureService.findById(id);
        if(culture == null) {
            return Result.error(404, "未找到记录");
        }else{
            return Result.success(culture);
        }
    }

    @GetMapping("/all")
    public Result<List<Culture>> getAllCulture() {
        List<Culture> cultures = cultureService.findAll();
        return Result.success(cultures);
    }

    @GetMapping("/search")
    public List<Culture> search(
            @RequestParam(value = "name", required = false) String name) {

        // 直接调用Service层的方法，并将参数传递过去
        return cultureService.serach(name);
    }

    /**
     * 新建
     * @param culture
     * @return
     */
    @PostMapping
    public Result<Culture> addCulture(@RequestBody Culture culture) {
        boolean success = cultureService.addCulture(culture);
        if(success) {
            return Result.success(culture);
        }else  {
            return Result.error(500, "添加失败");
        }
    }

    @PutMapping
    public Result<Culture> updateCulture(@RequestBody Culture culture) {
        boolean success = cultureService.updateCulture(culture);
        if(success) {
            return Result.success(culture);
        }else {
            return Result.error(404, "更新失败，未找到记录");
        }
    }

    @DeleteMapping("/{id}")
    public Result<Culture> deleteFood(@PathVariable Integer id) {
        boolean success = cultureService.deleteCulture(id);
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
    public Result<PageResult<Culture>> list(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {

        PageResult<Culture> pageResult = cultureService.list(name, pageNum, pageSize);
        return Result.success(pageResult);
    }

}

