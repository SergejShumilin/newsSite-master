package by.shumilin.example.repository;

import by.shumilin.example.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NewsRepository extends JpaRepository<News, Integer> {
    News findById(long newsId);

    void save(String title, String content);
}
