package by.shumilin.example.service;

import by.shumilin.example.entity.Comment;
import by.shumilin.example.repository.CommentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteById(long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> findAllByNewsId(long newsId) {
        List<Comment> allByNewsId = commentRepository.findAllByNewsId(newsId);
        return allByNewsId;
    }
}
