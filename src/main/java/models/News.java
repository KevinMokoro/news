package models;

import java.util.Objects;

public class News {

    private String news;
    private int departmentid;
    private int id;

    public News(String news, int departmentid, int id) {
        this.news = news;
        this.departmentid = departmentid;
        this.id = id;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news1 = (News) o;
        return departmentid == news1.departmentid &&
                id == news1.id &&
                Objects.equals(news, news1.news);
    }

    @Override
    public int hashCode() {
        return Objects.hash(news, departmentid, id);
    }
}
