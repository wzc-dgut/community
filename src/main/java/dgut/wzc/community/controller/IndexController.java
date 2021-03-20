package dgut.wzc.community.controller;

import dgut.wzc.community.mapper.UserMapper;
import dgut.wzc.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    //访问首页时 循环看所有cookie找到cookie等于token的cookie 去数据库里查是不是有这条cookie的记录 是就把user放到session里面
    //前端就能判断登录状态，如果一直没找到有相同的cookie说明没登录过或登录不成功
    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);//去数据库寻找该token值的用户信息

                //若找到了这个用户信息
                //写进session，让页面去展示
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }

        }
        return "index";
    }
}