package by.shumilin.example.service;


import by.shumilin.example.entity.News;

import java.util.List;

public interface NewsService {
    List<News> findAll();

    News findById(long newsId);

    void save(News news);
}
