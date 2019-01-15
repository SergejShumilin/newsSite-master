package by.shumilin.example.service;


import by.shumilin.example.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface NewsService {

    Iterable<News> findAll();

    News findById(long newsId);

    void save(News news);

    Page<News> findAll(PageRequest pageRequest);
}
