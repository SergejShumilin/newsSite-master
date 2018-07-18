package by.shumilin.example.service;

import by.shumilin.example.entity.Comment;

import java.util.List;

public interface CommentsGetFromDataBase {
    List<Comment> getComment(Long newsId);
}
