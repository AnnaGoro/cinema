package com.gorobchenkoa.model.dto;


import java.util.List;

public class BookDTO {

    private Integer id;
    private String author;
    private String title;
    private int balance;
    private List<UserDTO> users;
    private List<ReportDTO> report;
    private int startNumber;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ReportDTO> getReport() {
        return report;
    }

    public void setReport(List<ReportDTO> report) {
        this.report = report;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }
}