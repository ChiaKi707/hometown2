package cyber.hometown2.controller;

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

}
