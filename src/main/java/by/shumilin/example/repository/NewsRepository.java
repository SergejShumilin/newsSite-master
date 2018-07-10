package by.shumilin.example.repository;

import by.shumilin.example.entity.News;

import java.util.List;

public interface NewsRepository {
    void save(String title, String content);

    List<News> getNews(long id);

    List<News> getAllNews();


}
