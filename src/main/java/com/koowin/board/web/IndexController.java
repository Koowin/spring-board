package com.koowin.board.web;

import com.koowin.board.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";     //view resolver 가 templates/index.mustache 를 찾아서 처리함
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

}
