package by.shumilin.example.repository;

public interface CommentRepository {
    void save(String commentContent, Long newsId);
}
