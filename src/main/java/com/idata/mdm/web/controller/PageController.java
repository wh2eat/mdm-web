package com.idata.mdm.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idata.mdm.web.controller.dto.UserDTO;
import com.idata.mdm.web.service.ServiceException;
import com.idata.mdm.web.service.UserService;
import com.idata.mdm.web.service.vo.UserVo;

@Controller
public class PageController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(path = { "/" })
    public String toLoginPage() {
        return "login";
    }

    @RequestMapping(path = { "/login" })
    public String login(UserDTO userDTO, HttpServletRequest request) {

        LOGGER.debug("[][][" + userDTO + "]");

        UserVo loginUserVo = userDTO.convertToUser();

        try {
            boolean loginStatus = userService.login(loginUserVo);
            if (loginStatus) {
                UserVo dbUserVo = userService.getLoginUser(loginUserVo);
                request.getSession().setAttribute("loginUser", dbUserVo);
                userDTO = null;
                return "redirect:/user/index";
            }
        }
        catch (ServiceException e) {
            request.setAttribute("errorCode", e.getCode());
        }

        request.setAttribute("loginUser", userDTO);

        return "forward:/";
    }

    @RequestMapping(path = "/logout")
    public String logout() {
        LOGGER.debug("[][][logout]");
        return "redirect:/";
    }

    @RequestMapping(path = "/user/index")
    public String userIndex() {
        LOGGER.debug("[][][]");
        return "user/index";
    }

}
