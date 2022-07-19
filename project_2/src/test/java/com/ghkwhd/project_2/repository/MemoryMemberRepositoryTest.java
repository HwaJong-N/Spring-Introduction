package com.ghkwhd.project_2.repository;

import com.ghkwhd.project_2.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");

        // 저장
        repository.save(member);

        // 검증
        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findById() {
        Member member = new Member();
        member.setName("spring");

        // 저장
        repository.save(member);

        // 검증
        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member = new Member();
        member.setName("spring1");

        // 저장
        repository.save(member);

        // 검증
        Member result = repository.findByName(member.getName()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findALl() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);

    }
}