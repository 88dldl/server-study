package umc.spring.domain.mapping;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.common.BaseEntity;

@Entity
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
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
            name = "category_id"
    )
    private FoodCategory foodCategory;

    public static MemberPreferBuilder builder() {
        return new MemberPreferBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Member getMember() {
        return this.member;
    }

    public FoodCategory getFoodCategory() {
        return this.foodCategory;
    }

    protected MemberPrefer() {
    }

    public MemberPrefer(final Long id, final Member member, final FoodCategory foodCategory) {
        this.id = id;
        this.member = member;
        this.foodCategory = foodCategory;
    }

    public static class MemberPreferBuilder {
        private Long id;
        private Member member;
        private FoodCategory foodCategory;

        MemberPreferBuilder() {
        }

        public MemberPreferBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public MemberPreferBuilder member(final Member member) {
            this.member = member;
            return this;
        }

        public MemberPreferBuilder foodCategory(final FoodCategory foodCategory) {
            this.foodCategory = foodCategory;
            return this;
        }

        public MemberPrefer build() {
            return new MemberPrefer(this.id, this.member, this.foodCategory);
        }

        public String toString() {
            return "MemberPrefer.MemberPreferBuilder(id=" + this.id + ", member=" + this.member + ", foodCategory=" + this.foodCategory + ")";
        }
    }
}
