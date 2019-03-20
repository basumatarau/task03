package htp.basumatarau.task03.beans;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "newsCategories")
public class NewsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategory")
    private int idCategory;
    @Column(name = "categoryName")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<NewsItem> newsItemSet;

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<NewsItem> getNewsItemSet() {
        return newsItemSet;
    }

    public void setNewsItemSet(Set<NewsItem> newsItemSet) {
        this.newsItemSet = newsItemSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsCategory that = (NewsCategory) o;
        return idCategory == that.idCategory &&
                Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory, categoryName);
    }
}
