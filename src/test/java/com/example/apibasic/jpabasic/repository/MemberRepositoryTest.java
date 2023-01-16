package com.example.apibasic.jpabasic.repository;

import com.example.apibasic.jpabasic.entity.Gender;
import com.example.apibasic.jpabasic.entity.MemberEntity;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void bulkInsert(){
        MemberEntity saveMember1 = MemberEntity.builder()
                .account("qorwltn1234222")
                .password("1234")
                .nickName("시타1")
                .gender(Gender.FEMALE).build();
        //when : 시레
        memberRepository.save(saveMember1);

        MemberEntity saveMember2 = MemberEntity.builder()
                .account("qdsacr45")
                .password("1234")
                .nickName("시타2")
                .gender(Gender.FEMALE).build();
        //when : 시레
        memberRepository.save(saveMember2);

        MemberEntity saveMember3 = MemberEntity.builder()
                .account("qorwltn1234asdgart")
                .password("1234")
                .nickName("시타3")
                .gender(Gender.FEMALE).build();
        //when : 시레
        memberRepository.save(saveMember3);
    }
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

        //given
         //when
         List<MemberEntity> memberEntityList = memberRepository.findAll();
         //then
         assertEquals(3,memberEntityList.size());
         assertEquals("시타",memberEntityList.get(1).getNickName());
     }

    @Test
    @DisplayName("회원 데이터를 3개 등록하고 그 중 하나의 회원을 삭제해야 한다.")
    @Transactional
    @Rollback
    void deleteTest(){
        Long userCode =2L;
        memberRepository.deleteById(userCode);
        Optional<MemberEntity> foundMember = memberRepository.findById(userCode);
        //then
        assertFalse(foundMember.isPresent());
        assertEquals(2,memberRepository.findAll().size());

    }

    @Test
    @DisplayName("2번 회원의 닉네임과 성별을 수정해야 한다")
//    @Transactional
//    @Rollback

    void modifyTest(){
        Long userCode = 2L;
        String newNickName = "나루";
        Gender newGender = Gender.MALE;

        //when
        // JPA에서 수정은 조회 후 setter로 변경 후 다시 save
        Optional<MemberEntity> foundMember = memberRepository.findById(userCode);
        foundMember.ifPresent(m ->{
            m.setNickName(newNickName);
            m.setGender(newGender);
            memberRepository.save(m);
        });
        Optional<MemberEntity> modifiedMember = memberRepository.findById(userCode);
        //then
        assertEquals("나루",modifiedMember.get().getNickName());
        assertEquals(Gender.MALE,modifiedMember.get().getGender());
    }


}