package htp.basumatarau.task03.beans;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTag")
    private int idTag;
    @Column(name = "tag")
    private String tag;

    @ManyToMany(mappedBy = "tagSet")
    private Set<NewsItem> newsItemSet;

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Set<NewsItem> getNewsItemSet() {
        return newsItemSet;
    }

    public void setNewsItemSet(Set<NewsItem> newsItemSet) {
        this.newsItemSet = newsItemSet;
    }

    @Override
    public String toString() {
        return tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag1 = (Tag) o;
        return idTag == tag1.idTag &&
                Objects.equals(tag, tag1.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTag, tag);
    }
}
