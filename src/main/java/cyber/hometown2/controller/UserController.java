package cyber.hometown2.controller;

import cyber.hometown2.DTO.ChangePasswordDTO;
import cyber.hometown2.mapper.UserInfoMapper;
import cyber.hometown2.pojo.PageResult;
import cyber.hometown2.pojo.Result;
import cyber.hometown2.pojo.UserInfo;
import cyber.hometown2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Result<UserInfo> getAllUser(@PathVariable Integer id) {
        UserInfo user = userService.getUserById(id);
        if(user == null) {
            return Result.error(404, "未找到记录");
        }else{
            return Result.success(user);
        }
    }

    @GetMapping("/userlist")
    public Result<List<UserInfo>> getAllUser() {
        List<UserInfo> Userlist = userService.getUsers();
        return Result.success(Userlist);
    }

    @PostMapping("/updatauser")
    public Result updateUser(@RequestBody UserInfo user){
        userService.updateUser(user);
        return Result.success();
    }

    @PostMapping("/changePassword")
    public Result changePassword(@RequestBody ChangePasswordDTO dto) {

        boolean issuccess = userService.changePassword(
                dto.getUserId(),
                dto.getOldPassword(),
                dto.getNewPassword()
        );

        if(issuccess) {
            return Result.success();
        }
        return Result.error("旧密码不正确");
    }

    /**
     * 统一的分页列表查询接口
     * - 不传 name: 查询所有美食（分页）
     * - 传入 name: 按名称搜索美食（分页）
     */
    @GetMapping
    public Result<PageResult<UserInfo>> list(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {

        PageResult<UserInfo> pageResult = userService.list(name, pageNum, pageSize);
        return Result.success(pageResult);
    }

    @DeleteMapping("/{id}")
    public Result<UserInfo> deleteUser(@PathVariable Integer id) {
        boolean success = userService.deleteUser(id);
        if(success) {
            return Result.success();
        }
        else {
            return Result.error(404, "删除失败，未找到用户");
        }
    }

    @PutMapping
    public Result<UserInfo> 

}
