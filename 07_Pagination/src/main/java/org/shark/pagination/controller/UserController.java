package org.shark.pagination.controller;

import lombok.RequiredArgsConstructor;
import org.shark.pagination.model.dto.PageDTO;
import org.shark.pagination.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping("/list")
    public String list(PageDTO pageDTO, HttpServletRequest request, Model model){

        Map<String, Object> map = userService.getUsers(pageDTO, request);
        model.addAttribute("users", map.get("users"));
        model.addAttribute("pagingHtml", map.get("pagingHtml"));

        return "user/list";
    }
}
