package com.example.apibasic.post.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Builder
@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PostEntity {
    public static Long sequence = 1L;
    private Long postNo;
    private String writer;
    private String title;
    private String content;
    private List<String> hashTags;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
