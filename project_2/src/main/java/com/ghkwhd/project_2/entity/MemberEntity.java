package com.ghkwhd.project_2.entity;

import javax.persistence.*;

@Entity
public class MemberEntity {
    @Id // 대푯값을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 ID를 자동 생성
    private Long id;

    @Column
    private String name;
}
