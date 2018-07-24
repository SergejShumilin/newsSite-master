package by.shumilin.example.service;

import by.shumilin.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentDeleteFromDataBaseImpl implements CommentDeleteFromDataBase {

    @Autowired
    CommentRepository commentRepository;
    @Override
    public void delete(Long commentId) {
        commentRepository.delete(commentId);
    }
}
