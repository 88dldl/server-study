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

@Entity
public class Region extends BaseEntity {
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
    @OneToMany(
            mappedBy = "region",
            cascade = {CascadeType.ALL}
    )
    private List<Store> StoreList = new ArrayList();

    public static RegionBuilder builder() {
        return new RegionBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Store> getStoreList() {
        return this.StoreList;
    }

    protected Region() {
    }

    public Region(final Long id, final String name, final List<Store> StoreList) {
        this.id = id;
        this.name = name;
        this.StoreList = StoreList;
    }

    public static class RegionBuilder {
        private Long id;
        private String name;
        private List<Store> StoreList;

        RegionBuilder() {
        }

        public RegionBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public RegionBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public RegionBuilder StoreList(final List<Store> StoreList) {
            this.StoreList = StoreList;
            return this;
        }

        public Region build() {
            return new Region(this.id, this.name, this.StoreList);
        }

        public String toString() {
            return "Region.RegionBuilder(id=" + this.id + ", name=" + this.name + ", StoreList=" + this.StoreList + ")";
        }
    }
}
