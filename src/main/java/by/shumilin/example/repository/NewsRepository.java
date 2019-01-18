package by.shumilin.example.repository;

import by.shumilin.example.entity.News;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface NewsRepository extends PagingAndSortingRepository<News, Long> {
    News findById(long newsId);


}
