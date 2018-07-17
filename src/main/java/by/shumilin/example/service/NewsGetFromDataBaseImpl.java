package by.shumilin.example.service;

import by.shumilin.example.entity.News;
import by.shumilin.example.repository.NewsRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsGetFromDataBaseImpl implements NewsGetFromDataBase {

private static final Logger LOG = Logger.getLogger(NewsGetFromDataBaseImpl.class);
    @Autowired
    NewsRepository newsRepository;

    @Override
    public News getNews(long newsId) {
        News news = newsRepository.getNews(newsId);
        LOG.info("метод вызвался с id=" + newsId);
        return news;
    }

    @Override
    public List<News> getAllNews() {
        List<News> allNews = newsRepository.getAllNews();
        LOG.info("метод вызвался без парамметров");
        return allNews;
    }
}
