package umc.spring.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberAgree;

@Entity
public class Terms extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            length = 20
    )
    private String title;
    @Column(
            columnDefinition = "text"
    )
    private String body;
    @Column(
            columnDefinition = "boolean"
    )
    private boolean optional;
    @OneToMany(
            mappedBy = "terms",
            cascade = {CascadeType.ALL}
    )
    private List<MemberAgree> memberAgreeList = new ArrayList();

    public static TermsBuilder builder() {
        return new TermsBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public boolean isOptional() {
        return this.optional;
    }

    public List<MemberAgree> getMemberAgreeList() {
        return this.memberAgreeList;
    }

    protected Terms() {
    }

    public Terms(final Long id, final String title, final String body, final boolean optional, final List<MemberAgree> memberAgreeList) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.optional = optional;
        this.memberAgreeList = memberAgreeList;
    }

    public static class TermsBuilder {
        private Long id;
        private String title;
        private String body;
        private boolean optional;
        private List<MemberAgree> memberAgreeList;

        TermsBuilder() {
        }

        public TermsBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public TermsBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public TermsBuilder body(final String body) {
            this.body = body;
            return this;
        }

        public TermsBuilder optional(final boolean optional) {
            this.optional = optional;
            return this;
        }

        public TermsBuilder memberAgreeList(final List<MemberAgree> memberAgreeList) {
            this.memberAgreeList = memberAgreeList;
            return this;
        }

        public Terms build() {
            return new Terms(this.id, this.title, this.body, this.optional, this.memberAgreeList);
        }

        public String toString() {
            return "Terms.TermsBuilder(id=" + this.id + ", title=" + this.title + ", body=" + this.body + ", optional=" + this.optional + ", memberAgreeList=" + this.memberAgreeList + ")";
        }
    }
}