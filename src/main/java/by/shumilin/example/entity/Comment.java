package by.shumilin.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    private String content;

    @ManyToOne
    private News news;

    public Comment() {
    }

    public Comment(String content) {
        this.content = content;
    }

    public Comment(String content, News news) {
        this.content = content;
        this.news = news;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(news, comment.news);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, content, news);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", news=" + news +
                '}';
    }
}
