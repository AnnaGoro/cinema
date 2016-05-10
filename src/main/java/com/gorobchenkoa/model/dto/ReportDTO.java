package com.gorobchenkoa.model.dto;

import java.util.Date;

/**
 * Created by Kovantonlenko on 12/22/2015.
 */
public class ReportDTO {

    private Integer id;
    private Date rentDate;
    private Date returnDate;
    private BookDTO book;

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
