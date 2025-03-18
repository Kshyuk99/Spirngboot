package edu.du.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    // 기본 URL로 접근 시 index.jsp로 이동
    @GetMapping("/")
    public String firstForm() {
        return "index";
    }
    // index.jsp를 반환

}

