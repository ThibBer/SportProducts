package be.henallux.spring.sportProjects.dataAccess.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="`order`")
public class OrderEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="user", referencedColumnName = "id")
    private UserEntity userEntity;

    public OrderEntity() {}

    public OrderEntity(Integer id, LocalDate date, UserEntity userEntity) {
        this.id = id;
        this.date = date;
        this.userEntity = userEntity;
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
