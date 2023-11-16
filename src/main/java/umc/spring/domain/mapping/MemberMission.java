package umc.spring.domain.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.MissionStatus;

@Entity
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(
            columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'"
    )
    private MissionStatus status;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "member_id"
    )
    private Member member;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "mission_id"
    )
    private Mission mission;

    public static MemberMissionBuilder builder() {
        return new MemberMissionBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public MissionStatus getStatus() {
        return this.status;
    }

    public Member getMember() {
        return this.member;
    }

    public Mission getMission() {
        return this.mission;
    }

    protected MemberMission() {
    }

    public MemberMission(final Long id, final MissionStatus status, final Member member, final Mission mission) {
        this.id = id;
        this.status = status;
        this.member = member;
        this.mission = mission;
    }

    public static class MemberMissionBuilder {
        private Long id;
        private MissionStatus status;
        private Member member;
        private Mission mission;

        MemberMissionBuilder() {
        }

        public MemberMissionBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public MemberMissionBuilder status(final MissionStatus status) {
            this.status = status;
            return this;
        }

        public MemberMissionBuilder member(final Member member) {
            this.member = member;
            return this;
        }

        public MemberMissionBuilder mission(final Mission mission) {
            this.mission = mission;
            return this;
        }

        public MemberMission build() {
            return new MemberMission(this.id, this.status, this.member, this.mission);
        }

        public String toString() {
            return "MemberMission.MemberMissionBuilder(id=" + this.id + ", status=" + this.status + ", member=" + this.member + ", mission=" + this.mission + ")";
        }
    }
}
