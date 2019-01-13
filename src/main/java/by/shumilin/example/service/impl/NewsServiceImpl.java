package by.shumilin.example.service.impl;

import by.shumilin.example.entity.News;
import by.shumilin.example.repository.NewsRepository;
import by.shumilin.example.service.NewsService;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private static final Logger LOG = Logger.getLogger(NewsServiceImpl.class);

    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAll() {
        LOG.info("Поиск всех новостей");
        return newsRepository.findAll();
    }

    @Override
    public News findById(long newsId) {
        LOG.info("Поиск новости с newsId = " + newsId);
        return newsRepository.findById(newsId);
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
        LOG.info("Сохранение новости");
    }
}
