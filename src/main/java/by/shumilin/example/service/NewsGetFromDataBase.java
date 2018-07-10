package by.shumilin.example.service;

import by.shumilin.example.entity.News;

import java.util.List;

public interface NewsGetFromDataBase {
    List<News> getNews(long id);

    List<News> getAllNews();
}
