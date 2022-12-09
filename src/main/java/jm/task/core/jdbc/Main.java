package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService userTest = new UserServiceImpl();

        userTest.createUsersTable();

        userTest.saveUser("Anton", "Petrov", (byte) 12);
        userTest.saveUser("Ivan", "Ivanov", (byte) 30);
        userTest.saveUser("Olga", "Jukova", (byte) 22);
        userTest.saveUser("Maria", "Kyznecova", (byte) 12);

        System.out.println(userTest.getAllUsers().toString());

        userTest.cleanUsersTable();

        userTest.dropUsersTable();
    }
}
