package org.shark.file.controller;

import lombok.RequiredArgsConstructor;
import org.shark.file.model.dto.AttachDTO;
import org.shark.file.model.dto.NoticeDTO;
import org.shark.file.service.NoticeService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("notices", noticeService.findNotices());
        return "notice/list";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "notice/write";
    }

    @PostMapping("/write")
    public String write(NoticeDTO noticeDTO, List<MultipartFile> files, RedirectAttributes redirectAttributes) {
        boolean result = noticeService.addNotice(noticeDTO, files);
        redirectAttributes.addFlashAttribute("msg", result ? "공지사항 등록 성공" : "공지사항 등록 실패");
        return "redirect:/notice/list";
    }

    @GetMapping("/detail")
    public String detail(Integer nid, Model model) {
        Map<String, Object> map = noticeService.findNoticeById(nid);
        model.addAttribute("notice", map.get("notice"));
        model.addAttribute("attaches", map.get("attaches"));
        return "notice/detail";
    }

    @GetMapping("/remove")
    public String remove(Integer nid, RedirectAttributes redirectAttributes) {
        boolean result = noticeService.deleteNoticeById(nid);
        redirectAttributes.addFlashAttribute("msg", result ? "공지사항 삭제 성공" : "공지사항 삭제 실패");
        return "redirect:/notice/list";
    }

    @GetMapping(value = "/download" , produces = "application/octet-stream")
    public ResponseEntity<Resource> download(Integer aid) throws UnsupportedEncodingException {
        AttachDTO attach = noticeService.findAttachById(aid);
        if (attach == null) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = noticeService.loadAttachAsResource(attach);
        if (!resource.exists() || !resource.isFile()) {
            return ResponseEntity.notFound().build();
        }

        String encodedFileName = URLEncoder.encode(attach.getOriginalFilename(), "UTF-8")
                .replaceAll("\\+", "%20");

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"")
                .body(resource);
    }

}
