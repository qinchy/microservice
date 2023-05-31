package com.qinchy.microservice.provider1.web.basic;


import com.qinchy.microservice.provider1.config.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    /**
     * 问候语：http://127.0.0.1:8080/hello?name=lisi
     *
     * @param name 用户名
     * @return
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(name = "name", defaultValue = "unknown user") String name) {
        return "Hello " + name;
    }

    /**
     * 返回用户信息：http://127.0.0.1:8080/user
     *
     * @return 用户信息
     */
    @RequestMapping("/user1")
    @ResponseBody
    public User user() {
        User user = new User();
        user.setName("theonefx");
        user.setAge(666);
        return user;
    }

    /**
     * 保存用户信息：http://127.0.0.1:8080/save_user?name=newName&age=11
     *
     * @param user
     * @return
     */
    @RequestMapping("/save_user")
    @ResponseBody
    public String saveUser(@RequestBody User user) {
        return user.getName() + ", age=" + user.getAge();
    }

    /**
     * 返回字符串：http://127.0.0.1:8080/html
     *
     * @return
     */
    @RequestMapping("/html")
    public String html() {
        return "index.html";
    }

    /**
     * 转换用户信息
     *
     * @param name 用户名
     * @param age  年龄
     * @param user 用户实体
     */
    @ModelAttribute
    public void parseUser(@RequestParam(name = "name", defaultValue = "unknown user") String name, @RequestParam(name = "age", defaultValue = "12") Integer age, User user) {
        user.setName(name);
        user.setAge(age);
    }
}
