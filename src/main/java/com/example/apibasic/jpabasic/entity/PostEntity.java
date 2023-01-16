package com.example.apibasic.jpabasic.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="postId")
@Entity
@Builder
@Table(name = "tbl_post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_code")
    private Long postNo;
    @Column(nullable = false, unique = true,length = 20)
    private String writer;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    private List<String> hashTags;
}
