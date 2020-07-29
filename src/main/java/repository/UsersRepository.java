package repository;

import model.UsersEntity;
import util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersRepository {
    public UsersEntity createUser(String login, String email, String password) {
        try (var connection = DBUtils.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format("INSERT INTO users(login, email, password) VALUES ('%s', '%s', '%s')", login, email, password));
            return findByEmail(email);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public UsersEntity findByID(Long userID) {
        try {
            return findUser("SELECT * FROM users WHERE id = " + userID);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public UsersEntity findByEmail(String email) {
        try {
            return findUser("SELECT * FROM users WHERE email = '" + email + "'");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private UsersEntity findUser(String query) throws SQLException {
        try (var connection = DBUtils.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            UsersEntity usersEntity = null;

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                usersEntity = new UsersEntity();
                usersEntity.setId(id);
                usersEntity.setLogin(login);
                usersEntity.setEmail(email);
                usersEntity.setPassword(password);
            }
            return usersEntity;

        } catch (SQLException throwables) {
            throw throwables;
        }
    }
}
