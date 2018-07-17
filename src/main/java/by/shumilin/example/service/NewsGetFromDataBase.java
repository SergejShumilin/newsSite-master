package by.shumilin.example.service;

import by.shumilin.example.entity.News;

import java.util.List;

public interface NewsGetFromDataBase {
    News getNews(long newsId);

    List<News> getAllNews();
}
