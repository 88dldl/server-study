package umc.spring.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import umc.spring.domain.common.BaseEntity;

@Entity
public class FoodCategory extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            length = 15
    )
    private String name;

    public static FoodCategoryBuilder builder() {
        return new FoodCategoryBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    protected FoodCategory() {
    }

    public FoodCategory(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static class FoodCategoryBuilder {
        private Long id;
        private String name;

        FoodCategoryBuilder() {
        }

        public FoodCategoryBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public FoodCategoryBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public FoodCategory build() {
            return new FoodCategory(this.id, this.name);
        }

        public String toString() {
            return "FoodCategory.FoodCategoryBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }
}
