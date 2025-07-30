package org.shark.mvc.controller;

import org.shark.mvc.model.dto.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;

@RequestMapping("/b")
@Controller
public class MvcControllerB {

    @RequestMapping("/list")
    public String methodA(HttpServletRequest request) {

        String sort = request.getParameter("sort");
        if (!("ASC".equalsIgnoreCase(sort) || "DESC".equalsIgnoreCase(sort))) {
            sort = "DESC";
        }

        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception ignored) {
        }

        return "b/list";
    }

    @RequestMapping("/detail")
    public String methodB(
            @RequestParam(name = "bid") int bid
            , @RequestParam String code
            , String url) {

        System.out.println("bid:" + bid + " code:" + code + " url:" + url);

        return "b/detail";
    }

    @RequestMapping("/regist")
    public String methodC(BoardDTO board) {
        System.out.println("board: " + board);

        return "b/regist";
    }

    @RequestMapping("/boards/{bid}")
    public String methodD(@PathVariable int bid) {
        System.out.println("bid:" + bid);

        return "b/detail";
    }
}
