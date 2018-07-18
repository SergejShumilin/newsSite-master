package by.shumilin.example.repository;

import by.shumilin.example.entity.Comment;

import java.util.List;

public interface CommentRepository {
    void save(String commentContent, Long newsId);

    List<Comment> getComment(Long newsId);
}
