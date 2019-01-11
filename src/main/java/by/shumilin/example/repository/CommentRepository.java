package by.shumilin.example.repository;

import by.shumilin.example.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByNewsId(long newsId);


}
