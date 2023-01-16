package com.example.apibasic.post.dto;

import com.example.apibasic.post.entity.PostEntity;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class PostCreateDTO {
    /*
    *       NotNull : null 값일 경우 에러발생
    *       NotEmpty : 빈 문자열일 경우 에러발생
    *       NotBlank : null 이거나 빈 문자열일 경우 에러발생
    * */
    @NotBlank
    @Size(min =2, max = 5)
    private String writer;
    @NotBlank
    @Min(1) @Max(20)
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
