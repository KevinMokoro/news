package dao;

import models.Department;
import models.DepartmentNews;
import models.User;
import org.sql2o.*;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments (name, description, noofemployees) VALUES (:name, :description, :noOfEmployees);";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}