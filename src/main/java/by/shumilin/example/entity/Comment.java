package by.shumilin.example.entity;

import java.util.Objects;

public class Comment {
    private long commentId;
    private String content;


    public long getId() {
        return commentId;
    }

    public void setId(long id) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return commentId == comment.commentId &&
                Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(commentId, content);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + commentId +
                ", content='" + content + '\'' +
                '}';
    }
}
