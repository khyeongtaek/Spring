package org.shark.hierarchy.controller;

import lombok.RequiredArgsConstructor;
import org.shark.hierarchy.model.dto.BbsDTO;
import org.shark.hierarchy.model.dto.PageDTO;
import org.shark.hierarchy.service.BbsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/bbs")
@RequiredArgsConstructor
public class BbsController {
    private final BbsService bbsService;

    @GetMapping("/list")
    public String list(PageDTO pageDTO, Model model) {
        Map<String, Object> map = bbsService.getBbsList(pageDTO);
        model.addAttribute("bbsList", map.get("bbsList"));
        model.addAttribute("pageDTO", map.get("pageDTO"));
        return "bbs/list";
    }

    @PostMapping("/writeBbs")
    public String writeBbs(BbsDTO bbsDTO, RedirectAttributes redirectAttributes, Model model) {
        try {

            boolean result = bbsService.addBbs(bbsDTO);
            redirectAttributes.addFlashAttribute("msg", result ? "게시글 등록 성공" : "게시글 등록 실패");
            return "redirect:/bbs/list";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorBbs", e.getMessage());
            return "bbs/list";

        }
    }

    @PostMapping("/writeReply")
    public String writeReply(BbsDTO bbsDTO, RedirectAttributes redirectAttributes, Model model) {
        try {
            boolean result = bbsService.addReply(bbsDTO);
            redirectAttributes.addFlashAttribute("msg", result ? "답글 등록 성공" : "답글 등록 실패");
            return "redirect:/bbs/list";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorBbs", e.getMessage());
            return "bbs/list";

        }
    }

    @GetMapping("/remove")
    public String remove(Integer bbsId, RedirectAttributes redirectAttributes) {
        boolean result = bbsService.removeBbs(bbsId);
        redirectAttributes.addFlashAttribute("msg", result ? "게시글/답글 삭제 성공" : "게시글/답글 삭제 실패");
        return "redirect:/bbs/list";
    }
}
