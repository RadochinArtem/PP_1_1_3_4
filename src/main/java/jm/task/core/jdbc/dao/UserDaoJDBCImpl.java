package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String s = "CREATE TABLE IF NOT EXISTS `User` " +
                "(" +
                "`id` INT NOT NULL AUTO_INCREMENT," +
                "`name` VARCHAR(45) NULL," +
                "`lastname` VARCHAR(45) NULL," +
                "`age` INT(3) NULL, " +
                "PRIMARY KEY (`id`));";

        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String s = "DROP TABLE IF EXISTS `User`";

        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void saveUser(String name, String lastName, byte age) {
        String s = "INSERT `PP`.`User`(name, lastName, age) VALUES ('" +
                name
                + "','"
                + lastName
                + "',"
                + age
                + ")";
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate(s);
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void removeUserById(long id) {
        String s = "DELETE FROM `User` WHERE `ID` =" + id;
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() {
        String s = "SELECT * FROM `User`";
        List<User> listUsers = new ArrayList<>();
        try (ResultSet resultSet = Util.getConnection().createStatement().executeQuery(s)) {

            while (resultSet.next()) {
                User user = new User();
                user.setId((long) resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge((byte) resultSet.getInt(4));
                listUsers.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUsers;
    }

    public void cleanUsersTable() {
        String s = "TRUNCATE TABLE `User`";
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
