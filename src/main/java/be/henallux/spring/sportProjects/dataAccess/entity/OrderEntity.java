package be.henallux.spring.sportProjects.dataAccess.entity;

import be.henallux.spring.sportProjects.model.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="order")
public class OrderEntity {
    @Id private Integer id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="user", referencedColumnName = "id")
    private UserEntity userEntity;

    public OrderEntity() {}

    public OrderEntity(Integer id, LocalDate date, UserEntity userEntity) {
        setId(id);
        setDate(date);
        setUserEntity(userEntity);
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", userEntity=" + userEntity +
                '}';
    }
}
