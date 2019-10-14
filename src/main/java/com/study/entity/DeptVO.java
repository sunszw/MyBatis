package com.study.entity;

import java.util.List;

public class DeptVO {
    private Integer id;
    private String deptName;
    private String info;
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "DeptVO{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", info='" + info + '\'' +
                ", users=" + users +
                '}';
    }
}
