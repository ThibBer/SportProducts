package be.henallux.spring.sportProjects.model;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Promotion {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Integer percentage;

    public Promotion() {}

    public Promotion(Integer id, Date startDate, Date endDate, Integer percentage) {
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

    public Date getStartDate() {
        return startDate;
    }

    public String getFormattedStartDate(Locale locale){
        return formatDate(startDate, locale);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getFormattedEndDate(Locale locale){
        return formatDate(endDate, locale);
    }

    private String formatDate(Date date, Locale locale){
        String pattern = "dd MMMM yyyy";
        SimpleDateFormat simpleDateFormat;

        if(locale == null){
            simpleDateFormat = new SimpleDateFormat(pattern);
        }else{
            simpleDateFormat = new SimpleDateFormat(pattern, locale);
        }


        return simpleDateFormat.format(date);
    }

    public void setEndDate(Date endDate) {
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
