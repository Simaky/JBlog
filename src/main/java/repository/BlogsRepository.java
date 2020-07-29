package repository;

import model.BlogsEntity;
import model.UsersEntity;
import util.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class BlogsRepository {
    public void createBlog(String title, String text, String userId) {
        try (var connection = DBUtils.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format("INSERT INTO blogs(title, body, author_id) VALUES ('%s', '%s', '%s')", title, text, userId));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<BlogsEntity> findByUserID(Long userID) {
        try {
            return getFromDB("SELECT * FROM blogs WHERE author_id = " + userID);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<BlogsEntity> getAll() {
        try {
            return getFromDB("SELECT * FROM blogs");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<BlogsEntity> getLimited(int limit) {
        try {
            return getFromDB("SELECT * FROM blogs LIMIT " + limit);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private ArrayList<BlogsEntity> getFromDB(String query) throws SQLException {
        try (var connection = DBUtils.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<BlogsEntity> blogsEntities = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String body = resultSet.getString("body");
                Long authorID = resultSet.getLong("author_id");
                Timestamp createdAt = resultSet.getTimestamp("created_at");

                var blogsEntity = new BlogsEntity();
                blogsEntity.setId(id);
                blogsEntity.setTitle(title);
                blogsEntity.setBody(body);
                blogsEntity.setAuthorId(authorID);
                blogsEntity.setCreatedAt(createdAt);

                blogsEntities.add(blogsEntity);
            }
            return blogsEntities;
        } catch (SQLException throwables) {
            throw throwables;
        }
    }
}
