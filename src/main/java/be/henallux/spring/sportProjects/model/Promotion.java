package be.henallux.spring.sportProjects.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Promotion {
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer percentage;

    public Promotion() {}

    public Promotion(Integer id, LocalDate startDate, LocalDate endDate, Integer percentage) {
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

    public String getFormattedStartDate(){
        return startDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getFormattedEndDate(){
        return endDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
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
