package models;

import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String address;
    private int phone;
    private String email;
    private int departmentid;
    private String position;
    private String roles;

    public User(int id, String username, String address, int phone, String email, int departmentid, String position, String roles) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.departmentid = departmentid;
        this.position = position;
        this.roles = roles;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return phone == user.phone &&
                departmentid == user.departmentid &&
                Objects.equals(username, user.username) &&
                Objects.equals(address, user.address) &&
                Objects.equals(email, user.email) &&
                Objects.equals(position, user.position) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, address, phone, email, departmentid, position, roles);
    }
}
