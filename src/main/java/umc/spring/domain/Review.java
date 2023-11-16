package umc.spring.domain;


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

@Entity
public class Review {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            columnDefinition = "text"
    )
    private String body;
    private Float score;
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
            name = "store_id"
    )
    private Store store;
    @OneToMany(
            mappedBy = "review",
            cascade = {CascadeType.ALL}
    )
    private List<ReviewImage> reviewImageList = new ArrayList();

    public static ReviewBuilder builder() {
        return new ReviewBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getBody() {
        return this.body;
    }

    public Float getScore() {
        return this.score;
    }

    public Member getMember() {
        return this.member;
    }

    public Store getStore() {
        return this.store;
    }

    public List<ReviewImage> getReviewImageList() {
        return this.reviewImageList;
    }

    protected Review() {
    }

    public Review(final Long id, final String body, final Float score, final Member member, final Store store, final List<ReviewImage> reviewImageList) {
        this.id = id;
        this.body = body;
        this.score = score;
        this.member = member;
        this.store = store;
        this.reviewImageList = reviewImageList;
    }

    public static class ReviewBuilder {
        private Long id;
        private String body;
        private Float score;
        private Member member;
        private Store store;
        private List<ReviewImage> reviewImageList;

        ReviewBuilder() {
        }

        public ReviewBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ReviewBuilder body(final String body) {
            this.body = body;
            return this;
        }

        public ReviewBuilder score(final Float score) {
            this.score = score;
            return this;
        }

        public ReviewBuilder member(final Member member) {
            this.member = member;
            return this;
        }

        public ReviewBuilder store(final Store store) {
            this.store = store;
            return this;
        }

        public ReviewBuilder reviewImageList(final List<ReviewImage> reviewImageList) {
            this.reviewImageList = reviewImageList;
            return this;
        }

        public Review build() {
            return new Review(this.id, this.body, this.score, this.member, this.store, this.reviewImageList);
        }

        public String toString() {
            return "Review.ReviewBuilder(id=" + this.id + ", body=" + this.body + ", score=" + this.score + ", member=" + this.member + ", store=" + this.store + ", reviewImageList=" + this.reviewImageList + ")";
        }
    }
}
