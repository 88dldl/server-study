package umc.spring.domain;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberMission;

@Entity
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private int reward;
    @Column(
            columnDefinition = "datetime"
    )
    private LocalDate deadline;
    @Column(
            columnDefinition = "text"
    )
    private String mission_spec;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "store_id"
    )
    private Store store;
    @OneToMany(
            mappedBy = "mission",
            cascade = {CascadeType.ALL}
    )
    private List<MemberMission> memberMissionList = new ArrayList();

    public static MissionBuilder builder() {
        return new MissionBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public int getReward() {
        return this.reward;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }

    public String getMission_spec() {
        return this.mission_spec;
    }

    public Store getStore() {
        return this.store;
    }

    public List<MemberMission> getMemberMissionList() {
        return this.memberMissionList;
    }

    protected Mission() {
    }

    public Mission(final Long id, final int reward, final LocalDate deadline, final String mission_spec, final Store store, final List<MemberMission> memberMissionList) {
        this.id = id;
        this.reward = reward;
        this.deadline = deadline;
        this.mission_spec = mission_spec;
        this.store = store;
        this.memberMissionList = memberMissionList;
    }

    public static class MissionBuilder {
        private Long id;
        private int reward;
        private LocalDate deadline;
        private String mission_spec;
        private Store store;
        private List<MemberMission> memberMissionList;

        MissionBuilder() {
        }

        public MissionBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public MissionBuilder reward(final int reward) {
            this.reward = reward;
            return this;
        }

        public MissionBuilder deadline(final LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        public MissionBuilder mission_spec(final String mission_spec) {
            this.mission_spec = mission_spec;
            return this;
        }

        public MissionBuilder store(final Store store) {
            this.store = store;
            return this;
        }

        public MissionBuilder memberMissionList(final List<MemberMission> memberMissionList) {
            this.memberMissionList = memberMissionList;
            return this;
        }

        public Mission build() {
            return new Mission(this.id, this.reward, this.deadline, this.mission_spec, this.store, this.memberMissionList);
        }

        public String toString() {
            return "Mission.MissionBuilder(id=" + this.id + ", reward=" + this.reward + ", deadline=" + this.deadline + ", mission_spec=" + this.mission_spec + ", store=" + this.store + ", memberMissionList=" + this.memberMissionList + ")";
        }
    }
}
