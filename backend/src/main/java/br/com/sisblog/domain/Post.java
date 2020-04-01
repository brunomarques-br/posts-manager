package br.com.sisblog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_post")
@NoArgsConstructor
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    private Date date;

    @Getter
    @Setter
    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Getter
    @Setter
    @Column(name = "body")
    private String body;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User author;

    public Post(Post post) {
        this.id = post.id;
        this.title = post.title;
        this.body = post.body;
        this.date = post.date;
        this.author = post.author;
    }

    public Post(Integer id, Date date, String title, String body, User author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post obj = (Post) o;
        return Objects.equals(id, obj.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
