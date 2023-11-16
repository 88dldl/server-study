package umc.spring.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.SocialType;
import umc.spring.domain.mapping.MemberAgree;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MemberPrefer;

@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            length = 20
    )
    private String name;
    private int age;
    @Column(
            nullable = false,
            length = 40
    )
    private String address;
    @Column(
            nullable = false,
            length = 40
    )
    private String specAddress;
    @Enumerated(EnumType.STRING)
    @Column(
            columnDefinition = "VARCHAR(10)"
    )
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(
            columnDefinition = "VARCHAR(10)"
    )
    private SocialType socialType;
    @Enumerated(EnumType.STRING)
    @Column(
            columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'"
    )
    private MemberStatus status;
    @Column(
            columnDefinition = "datetime"
    )
    private LocalDate inactiveDate;
    @Column(
            nullable = false,
            length = 50
    )
    private String email;
    private Integer point;
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberAgree> memberAgreeList = new ArrayList();
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberMission> memberMissionList = new ArrayList();
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberPrefer> memberPreferList = new ArrayList();
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<Review> reviewList = new ArrayList();

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getAddress() {
        return this.address;
    }

    public String getSpecAddress() {
        return this.specAddress;
    }

    public Gender getGender() {
        return this.gender;
    }

    public SocialType getSocialType() {
        return this.socialType;
    }

    public MemberStatus getStatus() {
        return this.status;
    }

    public LocalDate getInactiveDate() {
        return this.inactiveDate;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getPoint() {
        return this.point;
    }

    public List<MemberAgree> getMemberAgreeList() {
        return this.memberAgreeList;
    }

    public List<MemberMission> getMemberMissionList() {
        return this.memberMissionList;
    }

    public List<MemberPrefer> getMemberPreferList() {
        return this.memberPreferList;
    }

    public List<Review> getReviewList() {
        return this.reviewList;
    }

    protected Member() {
    }

    public Member(final Long id, final String name, final int age, final String address, final String specAddress, final Gender gender, final SocialType socialType, final MemberStatus status, final LocalDate inactiveDate, final String email, final Integer point, final List<MemberAgree> memberAgreeList, final List<MemberMission> memberMissionList, final List<MemberPrefer> memberPreferList, final List<Review> reviewList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.specAddress = specAddress;
        this.gender = gender;
        this.socialType = socialType;
        this.status = status;
        this.inactiveDate = inactiveDate;
        this.email = email;
        this.point = point;
        this.memberAgreeList = memberAgreeList;
        this.memberMissionList = memberMissionList;
        this.memberPreferList = memberPreferList;
        this.reviewList = reviewList;
    }

    public static class MemberBuilder {
        private Long id;
        private String name;
        private int age;
        private String address;
        private String specAddress;
        private Gender gender;
        private SocialType socialType;
        private MemberStatus status;
        private LocalDate inactiveDate;
        private String email;
        private Integer point;
        private List<MemberAgree> memberAgreeList;
        private List<MemberMission> memberMissionList;
        private List<MemberPrefer> memberPreferList;
        private List<Review> reviewList;

        MemberBuilder() {
        }

        public MemberBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public MemberBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public MemberBuilder age(final int age) {
            this.age = age;
            return this;
        }

        public MemberBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public MemberBuilder specAddress(final String specAddress) {
            this.specAddress = specAddress;
            return this;
        }

        public MemberBuilder gender(final Gender gender) {
            this.gender = gender;
            return this;
        }

        public MemberBuilder socialType(final SocialType socialType) {
            this.socialType = socialType;
            return this;
        }

        public MemberBuilder status(final MemberStatus status) {
            this.status = status;
            return this;
        }

        public MemberBuilder inactiveDate(final LocalDate inactiveDate) {
            this.inactiveDate = inactiveDate;
            return this;
        }

        public MemberBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder point(final Integer point) {
            this.point = point;
            return this;
        }

        public MemberBuilder memberAgreeList(final List<MemberAgree> memberAgreeList) {
            this.memberAgreeList = memberAgreeList;
            return this;
        }

        public MemberBuilder memberMissionList(final List<MemberMission> memberMissionList) {
            this.memberMissionList = memberMissionList;
            return this;
        }

        public MemberBuilder memberPreferList(final List<MemberPrefer> memberPreferList) {
            this.memberPreferList = memberPreferList;
            return this;
        }

        public MemberBuilder reviewList(final List<Review> reviewList) {
            this.reviewList = reviewList;
            return this;
        }

        public Member build() {
            return new Member(this.id, this.name, this.age, this.address, this.specAddress, this.gender, this.socialType, this.status, this.inactiveDate, this.email, this.point, this.memberAgreeList, this.memberMissionList, this.memberPreferList, this.reviewList);
        }

        public String toString() {
            return "Member.MemberBuilder(id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", address=" + this.address + ", specAddress=" + this.specAddress + ", gender=" + this.gender + ", socialType=" + this.socialType + ", status=" + this.status + ", inactiveDate=" + this.inactiveDate + ", email=" + this.email + ", point=" + this.point + ", memberAgreeList=" + this.memberAgreeList + ", memberMissionList=" + this.memberMissionList + ", memberPreferList=" + this.memberPreferList + ", reviewList=" + this.reviewList + ")";
        }
    }
}
