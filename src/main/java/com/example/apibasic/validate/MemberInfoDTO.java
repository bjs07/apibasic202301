package com.example.apibasic.validate;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberInfoDTO {
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min=2, max=5)
    private String password;
    private String userName;
    @JsonFormat(pattern = "yyMMdd")
    @Past //과거 날짜인지 검사
    private LocalDate birthOfDate;
    @Valid  //컴포지션 객체 값 검증
    private Address address;//주소 정보(도로명 주소 + 우편번호)
    @Valid
    private Card card;      //결제 카드 정보(카드정보 + 카드만료 기간)

}
