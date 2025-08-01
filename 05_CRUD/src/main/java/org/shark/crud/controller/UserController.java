package org.shark.crud.controller;

import lombok.RequiredArgsConstructor;
import org.shark.crud.service.UserService;
import org.shark.crud.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginForm(String redirectUrl, HttpServletRequest request, Model model) {
        if (redirectUrl == null || redirectUrl.isEmpty()) {
            String referer = request.getHeader("Referer");
            if (referer == null || referer.isEmpty()) {
                redirectUrl = "/";
            } else {
                redirectUrl = referer;
            }
        }

        model.addAttribute("redirectURL", redirectUrl);
        return "user/login";
    }


}
