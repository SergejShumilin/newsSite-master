package by.shumilin.example.repository;

import by.shumilin.example.entity.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    List<Comment> findAllByNewsId(long newsId);


}
