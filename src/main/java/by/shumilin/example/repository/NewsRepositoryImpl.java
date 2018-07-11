package by.shumilin.example.repository;

import by.shumilin.example.connection.DBWorker;
import by.shumilin.example.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsRepositoryImpl implements NewsRepository {

    @Autowired
    DBWorker dbWorker;

    private static final String INSERT = "INSERT INTO news(title, content, shortText, date) VALUES(?,?,?, Now())";
    private static final String SELECT_ALL = "SELECT * from news";
    private static final String QUERY = "SELECT * FROM news WHERE id = ?";


    @Override
    public void save(String title, String content) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbWorker.getConnection().prepareStatement(INSERT);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.setString(3, content.substring(0, 10));
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
    public List<News> getNews(long id) {

        PreparedStatement preparedStatement = null;
        List<News> oneNews = new ArrayList<>();
        try {
            preparedStatement = dbWorker.getConnection().prepareStatement(QUERY);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                News news =new News();
                news.setId(resultSet.getLong("id"));
                news.setTitle(resultSet.getString( "title"));
                news.setContent(resultSet.getString("content"));
                oneNews.add(news);

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
        return oneNews;
    }

    @Override
    public List<News> getAllNews() {

        PreparedStatement preparedStatement = null;
        List<News> allNews = new ArrayList<>();
        try {
            preparedStatement = dbWorker.getConnection().prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt(1));
                news.setTitle(resultSet.getString(2));
                news.setShortText(resultSet.getString(4));
                allNews.add(news);
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
        return allNews;
    }
}
