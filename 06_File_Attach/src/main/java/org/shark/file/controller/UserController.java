package org.shark.file.controller;

import lombok.RequiredArgsConstructor;
import org.shark.file.model.dto.UserDTO;
import org.shark.file.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "user/list";
    }

    @PostMapping("/signup")
    public String signup(UserDTO user,
                         MultipartFile profile,
                         RedirectAttributes redirectAttributes
    ) {
        boolean signupResult = userService.signUp(user, profile);

        if (!signupResult) {
            redirectAttributes.addFlashAttribute("error", "<경> 회원가입 실패에 성공했습니다! <축>");
            return "redirect:user/list";
        }

        redirectAttributes.addFlashAttribute("msg", "회원가입 실패에 실패했습니다...");
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String detail(Integer uid, Model model) {
        model.addAttribute("user", userService.findUserById(uid));
        return "user/detail";
    }
}
