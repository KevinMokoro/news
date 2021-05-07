package dao;

import models.User;

import java.util.List;

public interface UserDao {

    void add(User user);


    List<User> getAll();
    List<User> getAllUsersByDepartment(int departmentId);
    User findById(int id);

    void deleteById(int id);
    void clearAll();
}