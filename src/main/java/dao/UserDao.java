package dao;

import models.User;

import java.util.List;

public interface UserDao {

    void add(User user);


    List<User> getAll();

    User findById(int id);

    void deleteById(int id);
    void clearAll();
}