package umc.spring.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReviewImage {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            columnDefinition = "text"
    )
    private String image_url;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "review_id"
    )
    private Review review;

    public static ReviewImageBuilder builder() {
        return new ReviewImageBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public Review getReview() {
        return this.review;
    }

    protected ReviewImage() {
    }

    public ReviewImage(final Long id, final String image_url, final Review review) {
        this.id = id;
        this.image_url = image_url;
        this.review = review;
    }

    public static class ReviewImageBuilder {
        private Long id;
        private String image_url;
        private Review review;

        ReviewImageBuilder() {
        }

        public ReviewImageBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ReviewImageBuilder image_url(final String image_url) {
            this.image_url = image_url;
            return this;
        }

        public ReviewImageBuilder review(final Review review) {
            this.review = review;
            return this;
        }

        public ReviewImage build() {
            return new ReviewImage(this.id, this.image_url, this.review);
        }

        public String toString() {
            return "ReviewImage.ReviewImageBuilder(id=" + this.id + ", image_url=" + this.image_url + ", review=" + this.review + ")";
        }
    }
}
