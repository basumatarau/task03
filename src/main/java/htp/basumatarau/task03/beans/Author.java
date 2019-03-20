package htp.basumatarau.task03.beans;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAuthor")
    private int idAuthor;
    @Column(name = "author")
    private String author;

    @ManyToMany(mappedBy = "authorSet")
    private Set<NewsItem> newsItemSet;

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<NewsItem> getNewsItemSet() {
        return newsItemSet;
    }

    public void setNewsItemSet(Set<NewsItem> newsItemSet) {
        this.newsItemSet = newsItemSet;
    }

    @Override
    public String toString() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author1 = (Author) o;
        return idAuthor == author1.idAuthor &&
                Objects.equals(author, author1.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAuthor, author);
    }
}
