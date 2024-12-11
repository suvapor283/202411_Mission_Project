package com.korea.blog.domain.main;

import com.korea.blog.domain.main.note.entity.Note;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @PostConstruct
    public void init() {

        mainService.init();
    }

    @RequestMapping("/")
    public String main() {

        return "main";
    }
}