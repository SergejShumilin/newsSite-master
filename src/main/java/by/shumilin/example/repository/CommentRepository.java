package by.shumilin.example.repository;

import by.shumilin.example.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByNewsId(long newsId);

    void deleteByCommentId(Long commentId);
}
