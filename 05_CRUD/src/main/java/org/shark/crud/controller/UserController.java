package org.shark.crud.controller;

import lombok.RequiredArgsConstructor;
import org.shark.crud.model.dto.UserDTO;
import org.shark.crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginForm(String url, Model model) {
        model.addAttribute("url", url);
        return "user/login";
    }

    /*
     * 요청 파라미터 3개, 로그인 실패 시 메시지 담아서 다시 로그인 펭지ㅣ, 로그인 성공시 세션에 nickname
     * */
    @PostMapping("/login")
    public String login(String url
            , UserDTO userDTO
            , HttpServletRequest request
            , RedirectAttributes redirectAttributes) {

        UserDTO user = userService.findUserByEmailAndPassword(userDTO);
        if (user == null) {
            redirectAttributes
                    .addFlashAttribute("error", "아이디/비밀번호를 확인하세요.")
                    .addAttribute("url", url);
            return "redirect:/user/login";
        }

        request.getSession().setAttribute("nickname", user.getNickname());
        redirectAttributes.addFlashAttribute("msg", user.getNickname() + "님 환영합니다.");

        return "redirect:" + (url == null ? request.getContextPath() : url);

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


}
