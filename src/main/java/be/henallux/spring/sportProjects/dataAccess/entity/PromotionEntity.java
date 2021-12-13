package be.henallux.spring.sportProjects.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "promotion")
public class PromotionEntity {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @Column(name="percentage")
    private Integer percentage;

    public PromotionEntity() {}

    public PromotionEntity(Integer id, LocalDate startDate, LocalDate endDate, Integer percentage) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percentage = percentage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", percentage=" + percentage +
                '}';
    }
}
