package by.shumilin.example.service;

import by.shumilin.example.entity.Comment;

import java.util.List;


public interface CommentService {
    void save(Comment comment);

    void deleteById(long commentId);

    List<Comment> findAllByNewsId(long newsId);
}
