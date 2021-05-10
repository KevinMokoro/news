import static spark.Spark.*;

import Exceptions.ApiException;
import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oDepartmentNewsDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import org.sql2o.*;
import models.*;


public class App {
    public static void main(String[] args) {
        Sql2oDepartmentNewsDao departmentNewsDao;
        Sql2oNewsDao newsDao;
        Sql2oUserDao userDao;
        Sql2oDepartmentDao departmentDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/org_api";
        Sql2o sql2o = new Sql2o(connectionString, "kevin", "  ");


        departmentDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        departmentNewsDao = new Sql2oDepartmentNewsDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();



        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });

        get("/departments", "application/json", (req, res) -> {
            return gson.toJson(departmentDao.getAll());
        });



        get("/departments/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = departmentDao.findById(departmentId);
            if (departmentToFind == null ){
                throw new ApiException(404, String.format("No department with id: %s exists", req.params("id")));
            }
            return gson.toJson(departmentToFind);
        });

        post("/departments/:id/users/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = departmentDao.findById(departmentId);
            if (departmentToFind == null ){
                throw new ApiException(404, String.format("No department with id: %s exists", req.params("id")));
            } else {
                user.setDepartmentId(departmentId);
                userDao.add(user);
                res.status(201);
                return gson.toJson(user);
            }
        });




    }
}
