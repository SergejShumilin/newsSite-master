package by.shumilin.example.repository;

import by.shumilin.example.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NewsRepository extends JpaRepository<News, Long> {
    News findById(long newsId);

}
