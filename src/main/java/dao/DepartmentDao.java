package dao;

import models.Department;
import models.DepartmentNews;
import models.User;

import java.util.List;

public interface DepartmentDao {

    void add(Department department);

    List<Department> getAll();

    Department findById(int id);

    List<User> getAllUsersByDepartment(int departmentId);
    List<DepartmentNews> getAllNewsByDepartment (int departmentId);


    void update(int id, String name, String description, int noOfEmployees);


    void deleteById(int id);
    void clearAll();
}