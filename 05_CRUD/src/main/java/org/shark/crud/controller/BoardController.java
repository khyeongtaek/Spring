package org.shark.crud.controller;

import lombok.RequiredArgsConstructor;
import org.shark.crud.model.dto.BoardDTO;
import org.shark.crud.model.dto.UserDTO;
import org.shark.crud.service.BoardService;
import org.shark.crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final UserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("boardCount", boardService.getBoardCount());
        model.addAttribute("boards", boardService.findAllBoards());
        return "board/list";
    }

    @GetMapping("/write")
    public String writeForm(HttpSession session) {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(HttpSession session, BoardDTO board, RedirectAttributes redirectAttributes) {
        String nickname = (String) session.getAttribute("nickname");
        board.setUser(userService.findUserByNickname(nickname));
        boolean result = boardService.addBoard(board);
        redirectAttributes.addFlashAttribute("msg", result ? "등록 성공" : "등록 실패");

        return "redirect:/board/list";
    }

    @GetMapping("/detail")
    public String detail(Integer bid, Model model) {
        model.addAttribute("board", boardService.findBoardById(bid));
        return "board/detail";
    }

    @GetMapping("/modify")
    public String modifyForm(Integer bid, Model model) {
        model.addAttribute("board", boardService.findBoardById(bid));
        return "board/modify";
    }

    @PostMapping("/modify")
    public String modify(BoardDTO board, RedirectAttributes redirectAttributes) {
        boolean result = boardService.modifyBoard(board);
        redirectAttributes.addFlashAttribute("msg", result ? "수정 성공" : "수정 실패")
                .addAttribute("bid", board.getBid());
        return "redirect:/board/detail";
    }

    @GetMapping("/delete")
    public String delete(Integer bid, RedirectAttributes redirectAttributes) {
        boolean result = boardService.removeBoard(bid);
        redirectAttributes.addFlashAttribute("msg", result ? "삭제 성공" : "삭제 실패");
        return "redirect:/board/list";
    }
}
