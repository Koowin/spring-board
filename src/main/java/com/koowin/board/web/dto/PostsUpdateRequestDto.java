package com.koowin.board.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsUpdateRequestDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsUpdateRequestDto(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
