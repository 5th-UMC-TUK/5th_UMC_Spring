package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;
import umc.study.domain.mapping.MemberAgree;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MemberPrefer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    // 어떤 값이 저장될지 모르는 경우가 아니라 정해진 값들 중에 특정한 값이 저장
    // enum 타입 사용
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String specAddress;

    private LocalDate inactiveDate;

    private Long email;

    private int point;

    // 테이블은 조인을 통해 양방향 연관 관계 설정이 가능하지만
    // 객체는 객체를 참조하여 연관된 객체를 찾음
    // 따라서 다른 두 객체에 각각 단방향 연관 관계 설정해야 함
    // 일대다, 회원 한 명이 여러 개의 리뷰, 선호 음식 등 작성 가능

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL);
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL);
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL);
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL);
    private List<MemberMission> memberMissionList = new ArrayList<>();