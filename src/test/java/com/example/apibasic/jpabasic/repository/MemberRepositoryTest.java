package com.example.apibasic.jpabasic.repository;

import com.example.apibasic.jpabasic.entity.Gender;
import com.example.apibasic.jpabasic.entity.MemberEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest     //스프링 컨테이너를 사용해서 스프링이 관리하는 객체를 주입받는 기능
class MemberRepositoryTest {
    // 스프링 빈을 주입받을 때 필드 주입을 사용
    @Autowired
    MemberRepository memberRepository;

    // 테스트 메서드
    // 단언(Assertion) : 강력히 주장한다.
    @Test
    @DisplayName("회원의 가입 정보를 데이터베이스에 저장해야 한다.")
    @Transactional
    @Rollback
    void saveTest(){
        //given - when - then 패턴
        //given : 테스트 시 주어지는 데이터
        MemberEntity saveMember = MemberEntity.builder()
                .account("qorwltn1234")
                .password("1234")
                .nickName("시타")
                .gender(Gender.FEMALE).build();
        //when : 시레
        memberRepository.save(saveMember);
        Optional<MemberEntity> foundMember = memberRepository.findById(1L);
        MemberEntity member = foundMember.get();
        assertNotNull(member);
        //assertEquals(1L,member.getUserId());
        assertEquals("시타",member.getNickName());
     }

     @Test
    @DisplayName("회원 목록을 조회하면 3명의 회원정보가 조회되어야 한다.")
     @Transactional
     @Rollback
    void findAllTest(){

        MemberEntity saveMember1 = MemberEntity.builder()
             .account("qorwltn1234222")
             .password("1234")
             .nickName("시타")
             .gender(Gender.FEMALE).build();
         //when : 시레
         memberRepository.save(saveMember1);

         MemberEntity saveMember2 = MemberEntity.builder()
                 .account("qdsacr45")
                 .password("1234")
                 .nickName("시타")
                 .gender(Gender.FEMALE).build();
         //when : 시레
         memberRepository.save(saveMember2);

         MemberEntity saveMember3 = MemberEntity.builder()
                 .account("qorwltn1234asdgart")
                 .password("1234")
                 .nickName("시타")
                 .gender(Gender.FEMALE).build();
         //when : 시레
         memberRepository.save(saveMember3);
        //given
         //when
         List<MemberEntity> memberEntityList = memberRepository.findAll();
         //then
         assertEquals(3,memberEntityList.size());
         assertEquals("시타",memberEntityList.get(1).getNickName());
     }
}