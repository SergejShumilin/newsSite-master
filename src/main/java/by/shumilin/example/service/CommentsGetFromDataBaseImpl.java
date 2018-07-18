package by.shumilin.example.service;

import by.shumilin.example.entity.Comment;
import by.shumilin.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentsGetFromDataBaseImpl implements CommentsGetFromDataBase {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> getComment(Long newsId) {
        List<Comment> comments = commentRepository.getComment(newsId);
        return comments;
    }
}
