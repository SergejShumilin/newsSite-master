package by.shumilin.example.service.impl;

import by.shumilin.example.entity.Comment;
import by.shumilin.example.repository.CommentRepository;
import by.shumilin.example.service.CommentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private static final Logger LOG = Logger.getLogger(CommentServiceImpl.class);

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
        LOG.info("Сохранение комментария");
    }

    @Override
    public void deleteById(long commentId) {
        commentRepository.deleteById(commentId);
        LOG.info("Удаление комментария с commentId = " + commentId);
    }

    @Override
    public List<Comment> findAllByNewsId(long newsId) {
        LOG.info("Поиск всех комментариев для новости с newsId = " + newsId);
        return commentRepository.findAllByNewsId(newsId);
    }
}
