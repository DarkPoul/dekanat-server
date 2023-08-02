package com.esvarog.ua.Dekanat.model.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "web_post")
public class Blog {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    public Blog(){}

    public Blog(int id, String title, String text, Date date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
