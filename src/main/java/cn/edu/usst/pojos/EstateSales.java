package cn.edu.usst.pojos;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Wan on 2016/9/8 0008.
 */
//spring使用的是jackson：参考注解：JsonProperty
@Table(name = "estate_sales")
@Entity
public class EstateSales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String area;
    @Column(name = "time_unit")
    private String timeUnit;
    @Column(name = "date_time")
    private Date dateTime;
    @Column(name = "sale_area")
    private String saleArea;
    @Column(name = "sale_num")
    private String saleNum;
    private String price;
    @Column(name = "month_on_month")
    private String monthOnMonth;
    @Column(name = "year_on_year")
    private String yearOnYear;
    @Column(name = "insert_time")
    private Date insertTime;
    @Column(name = "update_time")
    private Date updateTime;


    public EstateSales(String area, String saleArea, String saleNum) {
        this.area = area;
        this.saleArea = saleArea;
        this.saleNum = saleNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonthOnMonth() {
        return monthOnMonth;
    }

    public void setMonthOnMonth(String monthOnMonth) {
        this.monthOnMonth = monthOnMonth;
    }

    public String getYearOnYear() {
        return yearOnYear;
    }

    public void setYearOnYear(String yearOnYear) {
        this.yearOnYear = yearOnYear;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }

    public String getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(String saleNum) {
        this.saleNum = saleNum;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "EstateSales{" +
                "area='" + area + '\'' +
                ", timeUnit='" + timeUnit + '\'' +
                ", dateTime=" + dateTime +
                ", saleArea='" + saleArea + '\'' +
                ", saleNum='" + saleNum + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
