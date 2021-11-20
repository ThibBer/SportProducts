package be.henallux.spring.sportProjects.model;

import java.time.LocalDate;

public class Order {
    private Integer id;
    private LocalDate date;
    private User user;

    public Order() {}

    public Order(Integer id, LocalDate date, User user) {
        setId(id);
        setDate(date);
        setUser(user);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
