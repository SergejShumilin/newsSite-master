package by.shumilin.example.service;

import by.shumilin.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentSaveToDataBaseImpl implements CommentSaveToDataBase {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void save(String contentContent, Long newsId) {
        commentRepository.save(contentContent, newsId);
    }
}
