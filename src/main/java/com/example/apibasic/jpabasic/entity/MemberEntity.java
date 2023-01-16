package com.example.apibasic.jpabasic.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of="userId")
@Entity
@Builder
@Table(name = "tbl_member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_code")
    private Long userId;
    @Column(nullable = false, unique = true, length = 30) // NOT NULL, UNIQUE 제약조건
    private String account;
    @Column(nullable = false)
    private String password;
    @Column(name = "user_nick", nullable = false)
    private String nickName;
    private Gender gender;
    @CreationTimestamp
    private LocalDateTime joinDate;
    @UpdateTimestamp
    private LocalDateTime modifyDate;


}
