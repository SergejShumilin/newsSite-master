package by.shumilin.example.service;

import by.shumilin.example.entity.News;
import by.shumilin.example.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAll() {
        List<News> all = newsRepository.findAll();
        return all;
    }

    @Override
    public News findById(long newsId) {
        News newsbyId = newsRepository.findById(newsId);
        return newsbyId;
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }
}
