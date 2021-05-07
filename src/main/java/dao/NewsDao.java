
package dao;

import models.News;

import java.util.List;

public interface NewsDao {


    void add(News news);


    List<News> getAll();
    List<News> getAllNewsByDepartment(int departmentId);
    News findById(int id);


    void update(int id, String news, int departmentId);


    void deleteById(int id);
    void clearAll();
}