package htp.basumatarau.task03.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity(name = "newsItems")
public class NewsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNewsItem")
    private int idNewsItem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "newsCategory_idCategory")
    private NewsCategory category;

    @ManyToMany(mappedBy = "newsItemSet")
    private Set<Tag> tagSet;

    @ManyToMany(mappedBy = "newsItemSet")
    private Set<Author> authorSet;

    @Column(name = "publicationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publicationDate;
    @Column(name = "title")
    private String title;
    @Column(name = "intro")
    private String intro;
    @Column(name = "body")
    private String body;

    public int getIdNewsItem() {
        return idNewsItem;
    }

    public void setIdNewsItem(int idNewsItem) {
        this.idNewsItem = idNewsItem;
    }

    public NewsCategory getCategory() {
        return category;
    }

    public void setCategory(NewsCategory category) {
        this.category = category;
    }

    public Set<Tag> getTagSet() {
        return tagSet;
    }

    public void setTagSet(Set<Tag> tagSet) {
        this.tagSet = tagSet;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsItem newsItem = (NewsItem) o;
        return idNewsItem == newsItem.idNewsItem &&
                Objects.equals(category, newsItem.category) &&
                Objects.equals(tagSet, newsItem.tagSet) &&
                Objects.equals(authorSet, newsItem.authorSet) &&
                Objects.equals(publicationDate, newsItem.publicationDate) &&
                Objects.equals(title, newsItem.title) &&
                Objects.equals(intro, newsItem.intro) &&
                Objects.equals(body, newsItem.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNewsItem, category, tagSet, authorSet, publicationDate, title, intro, body);
    }
}
