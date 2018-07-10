package by.shumilin.example.service;

import by.shumilin.example.entity.News;
import by.shumilin.example.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsGetFromDataBaseImpl implements NewsGetFromDataBase {


    @Autowired
    NewsRepository newsRepository;

    @Override
    public List<News> getNews(long id) {
        List<News> news = newsRepository.getNews(id);
        return news;
    }

    @Override
    public List<News> getAllNews() {
        List<News> allNews = newsRepository.getAllNews();
        return allNews;
    }
}
