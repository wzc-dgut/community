package dgut.wzc.community.controller;

import dgut.wzc.community.dto.PaginationDTO;
import dgut.wzc.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    //访问首页时 循环看所有cookie找到cookie等于token的cookie 去数据库里查是不是有这条cookie的记录 是就把user放到session里面
    //前端就能判断登录状态，如果一直没找到有相同的cookie说明没登录过或登录不成功
    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                        @RequestParam(name = "search", required = false) String search
                        ) {
        PaginationDTO pagination = questionService.list(search,page,size);
        model.addAttribute("pagination", pagination);
        model.addAttribute("search",search);
        return "index";
    }
}