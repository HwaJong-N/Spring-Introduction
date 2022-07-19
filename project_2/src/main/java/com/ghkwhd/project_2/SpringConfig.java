package com.ghkwhd.project_2;

import com.ghkwhd.project_2.repository.MemberRepository;
import com.ghkwhd.project_2.repository.MemoryMemberRepository;
import com.ghkwhd.project_2.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
