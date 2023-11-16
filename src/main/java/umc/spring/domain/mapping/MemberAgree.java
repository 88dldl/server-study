package umc.spring.domain.mapping;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import umc.spring.domain.Member;
import umc.spring.domain.Terms;
import umc.spring.domain.common.BaseEntity;

@Entity
public class MemberAgree extends BaseEntity {
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
            name = "terms_id"
    )
    private Terms terms;

    public static MemberAgreeBuilder builder() {
        return new MemberAgreeBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Member getMember() {
        return this.member;
    }

    public Terms getTerms() {
        return this.terms;
    }

    protected MemberAgree() {
    }

    public MemberAgree(final Long id, final Member member, final Terms terms) {
        this.id = id;
        this.member = member;
        this.terms = terms;
    }

    public static class MemberAgreeBuilder {
        private Long id;
        private Member member;
        private Terms terms;

        MemberAgreeBuilder() {
        }

        public MemberAgreeBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public MemberAgreeBuilder member(final Member member) {
            this.member = member;
            return this;
        }

        public MemberAgreeBuilder terms(final Terms terms) {
            this.terms = terms;
            return this;
        }

        public MemberAgree build() {
            return new MemberAgree(this.id, this.member, this.terms);
        }

        public String toString() {
            return "MemberAgree.MemberAgreeBuilder(id=" + this.id + ", member=" + this.member + ", terms=" + this.terms + ")";
        }
    }
}
