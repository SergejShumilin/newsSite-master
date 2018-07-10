package by.shumilin.example.service;

import by.shumilin.example.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsSaveToDataBaseImpl implements NewsSaveToDataBase {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public void save(String title, String content) {
    newsRepository.save(title, content);
    }
}
