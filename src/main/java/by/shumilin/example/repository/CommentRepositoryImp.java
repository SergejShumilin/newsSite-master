package by.shumilin.example.repository;

import by.shumilin.example.connection.DBWorker;
import by.shumilin.example.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class CommentRepositoryImp implements CommentRepository {

    @Autowired
    DBWorker dbWorker;

    private static final String INSERT = "INSERT INTO comment(content, data, news_id) VALUES(?, Now(), ?)";

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
}
