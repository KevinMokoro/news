package dao;
import models.DepartmentNews;
import org.sql2o.*;

public class Sql2oDepartmentNewsDao implements DepartmentNewsDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void add(DepartmentNews news) {
        String sql = "INSERT INTO news (content, author, createdat, departmentid, type) VALUES (:content, :author, :createdAt, :departmentId, :DATABASETYPE);";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(sql, true)
                    .bind(news)
                    .addParameter("DATABASETYPE", DepartmentNews.getDATABASETYPE())
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
