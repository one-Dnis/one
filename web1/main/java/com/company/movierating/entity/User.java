package com.company.movierating.entity;

public class User {

    private int id;
    private String login;
    private String password;
    private String role;
    private double rank;
    private String info;

    public User() {
    }

    public User(int id, String login, String password, String role, double rank, String info) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.rank = rank;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (Double.compare(user.rank, rank) != 0) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!role.equals(user.role)) return false;
        return info.equals(user.info);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        temp = Double.doubleToLongBits(rank);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + info.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", rank=" + rank +
                ", info='" + info + '\'' +
                '}';
    }
}
