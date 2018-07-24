package by.shumilin.example.repository;

import by.shumilin.example.connection.DBWorker;
import by.shumilin.example.entity.Comment;
import by.shumilin.example.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommentRepositoryImp implements CommentRepository {

    @Autowired
    DBWorker dbWorker;

    private static final String INSERT = "INSERT INTO comment(comments, data, news_id) VALUES(?, Now(), ?)";
    private static final String QUERY_TO_DB_COMMENT = "SELECT * FROM comment WHERE news_id = ?";
    private static final String DROP = "DELETE From comment WHERE comment_id=?";

    @Override
    public void save(String commentContent, Long newsId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbWorker.getConnection().prepareStatement(INSERT);
            preparedStatement.setString(1, commentContent);
            preparedStatement.setLong(2, newsId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbWorker.getConnection().close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Comment> getComment(Long newsId) {
        PreparedStatement preparedStatement = null;
        List<Comment> comments = new ArrayList<>();
        try {
            preparedStatement = dbWorker.getConnection().prepareStatement(QUERY_TO_DB_COMMENT);
            preparedStatement.setLong(1, newsId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setCommentId(resultSet.getLong("comment_id"));
                comment.setContent(resultSet.getString("comments"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbWorker.getConnection().close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return comments;
    }

    @Override
    public void delete(Long commentId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbWorker.getConnection().prepareStatement(DROP);
            preparedStatement.setLong(1, commentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbWorker.getConnection().close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
