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
import umc.spring.domain.common.BaseEntity;

@Entity
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            length = 50
    )
    private String name;
    @Column(
            nullable = false,
            length = 50
    )
    private String address;
    private Float score;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "region_id"
    )
    private Region region;
    @OneToMany(
            mappedBy = "store",
            cascade = {CascadeType.ALL}
    )
    private List<Review> reviewList = new ArrayList();

    public static StoreBuilder builder() {
        return new StoreBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Float getScore() {
        return this.score;
    }

    public Region getRegion() {
        return this.region;
    }

    public List<Review> getReviewList() {
        return this.reviewList;
    }

    protected Store() {
    }

    public Store(final Long id, final String name, final String address, final Float score, final Region region, final List<Review> reviewList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.score = score;
        this.region = region;
        this.reviewList = reviewList;
    }

    public static class StoreBuilder {
        private Long id;
        private String name;
        private String address;
        private Float score;
        private Region region;
        private List<Review> reviewList;

        StoreBuilder() {
        }

        public StoreBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public StoreBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public StoreBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public StoreBuilder score(final Float score) {
            this.score = score;
            return this;
        }

        public StoreBuilder region(final Region region) {
            this.region = region;
            return this;
        }

        public StoreBuilder reviewList(final List<Review> reviewList) {
            this.reviewList = reviewList;
            return this;
        }

        public Store build() {
            return new Store(this.id, this.name, this.address, this.score, this.region, this.reviewList);
        }

        public String toString() {
            return "Store.StoreBuilder(id=" + this.id + ", name=" + this.name + ", address=" + this.address + ", score=" + this.score + ", region=" + this.region + ", reviewList=" + this.reviewList + ")";
        }
    }
}
