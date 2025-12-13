package cyber.hometown2.controller;

import cyber.hometown2.pojo.Result;
import cyber.hometown2.pojo.UserInfo;
import cyber.hometown2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserInfo loginuser) {
        UserInfo user = userService.getUserIdandPassword(loginuser);
        if (user != null) {
            return Result.success(user);
        }
        else {
            return Result.error(404,"用户名或密码错误");
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserInfo registeruser) {
        boolean success = userService.addUser(registeruser);
        if(success) {
            return Result.success(registeruser);
        }else  {
            return Result.error(500, "添加失败");
        }
    }

}
