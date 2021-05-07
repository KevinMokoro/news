package models;

import java.util.Objects;

public class User {
    private String name;
    private int id;
    private String position;
    private int departmentId;

    public User (String name,String position, int departmentId){
        this.name = name;
        this.position=position;
        this.departmentId =departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                departmentId == user.departmentId &&
                Objects.equals(name, user.name) &&
                Objects.equals(position, user.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, position, departmentId);
    }
}
