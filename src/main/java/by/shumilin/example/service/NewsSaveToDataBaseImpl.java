package by.shumilin.example.service;

import by.shumilin.example.repository.NewsRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsSaveToDataBaseImpl implements NewsSaveToDataBase {

    private static final Logger LOG = Logger.getLogger(NewsSaveToDataBaseImpl.class);

    @Autowired
    NewsRepository newsRepository;

    @Override
    public void save(String title, String content) {
    newsRepository.save(title, content);
     LOG.info("Метод вызван с title = " + title + "и content = " + content);
    }
}
