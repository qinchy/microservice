package com.qinchy.microservice.provider1.web.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathVariableController {

    /**
     * 获取登陆信息：http://127.0.0.1:8080/user/123/roles/222
     * @param userId 用户id
     * @param roleId 角色id
     * @return 登陆信息字符串
     */
    @RequestMapping(value = "/user/{userId}/roles/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public String getLogin(@PathVariable("userId") String userId, @PathVariable("roleId") String roleId) {
        return "User Id : " + userId + " Role Id : " + roleId;
    }

    /**
     * url中使用正则：http://127.0.0.1:8080/javabeat/somewords
     * @param regexp1 正则表达式
     * @return
     */
    @RequestMapping(value = "/javabeat/{regexp1:[a-z-]+}", method = RequestMethod.GET)
    @ResponseBody
    public String getRegExp(@PathVariable("regexp1") String regexp1) {
        return "URI Part : " + regexp1;
    }
}
