package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;

import javax.persistence.*;
import java.time.LocalDate;

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
}
