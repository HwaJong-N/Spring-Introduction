package com.ghkwhd.project_2.repository;

import com.ghkwhd.project_2.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    // 저장소에 저장
    Member save(Member member);

    // 찾기
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
