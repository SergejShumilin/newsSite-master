package by.shumilin.example.repository;

import by.shumilin.example.entity.Comment;
import by.shumilin.example.entity.News;

import java.util.List;

public interface NewsRepository {
    void save(String title, String content);

    News getNews(long newsId);

    List<News> getAllNews();




}
