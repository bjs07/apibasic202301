package com.example.apibasic.post.dto;

import com.example.apibasic.post.entity.PostEntity;

import java.util.List;

public class PostCreateDTO {
    private String writer;
    private String title;
    private String content;
    private List<String> hashTags;

    //PostEntity로 변환하는 유틸 메서드
    public PostEntity toEntity(){
        return PostEntity.builder()
                .postNo(PostEntity.sequence++)
                .writer(this.writer)
                .title(this.title)
                .content(this.content)
                .build();
    }
}
