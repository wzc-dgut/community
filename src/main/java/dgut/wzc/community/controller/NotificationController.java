package dgut.wzc.community.controller;

import dgut.wzc.community.dto.NotificationDTO;
import dgut.wzc.community.dto.PaginationDTO;
import dgut.wzc.community.enums.NotificationTypeEnum;
import dgut.wzc.community.mapper.NotificationMapper;
import dgut.wzc.community.model.User;
import dgut.wzc.community.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "id") Long id){
        User user = (User) request.getSession().getAttribute("user");
        //如果没登录就回index
        if(user == null){
            return "redirect:/";
        }

        NotificationDTO notificationDTO = notificationService.read(id,user);

        if(NotificationTypeEnum.REPLY_COMMENT.getType()== notificationDTO.getType() || NotificationTypeEnum.REPLY_QUESTION.getType() == notificationDTO.getType()){
            return "redirect:/question/" + notificationDTO.getOuterid();
        }else {
            return "redirect:/";
        }

    }
}
