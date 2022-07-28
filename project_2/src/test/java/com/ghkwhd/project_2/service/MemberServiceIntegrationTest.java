package com.ghkwhd.project_2.service;

import com.ghkwhd.project_2.domain.Member;
import com.ghkwhd.project_2.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
        MemberService memberService;
    @Autowired
        MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // given (주어진 상황)
        Member member = new Member();
        member.setName("hello");

        // when (어떤 것을 실행했을 떄)
        Long savedId = memberService.join(member);

        // then (결과가 어떤 것이 나와야 함)
        Member findMember = memberService.findOne(savedId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        // given (주어진 상황)
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        // when (어떤 것을 실행했을 떄)
        memberService.join(member1);
        // join 메소드를 실행했을 때, 예외가 발생해야함
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // 예외 메세지 확인
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try{
//            memberService.join(member2);
//            fail(); // 여기까지 실행되면 중복회원을 잡아내지 못한것
//        } catch (IllegalStateException e) {
//            // 예외 발생 시 설정한 메세지가 아래와 동일한지 확인
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}