package com.ammar.buxapp;

public class TicketModel {
    private String name;
    private String numberPhone;
    private int seats;
    private String seatsNo;
    private String poName;
    private String bookNumber;
    private String poNumber;
    private String startAt;
    private String endAt;
    private String startCity;
    private String endCity;
    private String startDate;
    private String endDate;
    private String startTerminal;
    private String endTerminal;
    private double total;

    public TicketModel(String name,
                       String numberPhone,
                       int seats,
                       String seatsNo,
                       String poName,
                       String bookNumber,
                       String poNumber,
                       String startAt,
                       String endAt,
                       String startCity,
                       String endCity,
                       String startDate,
                       String endDate,
                       String startTerminal,
                       String endTerminal,
                       double total) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.seats = seats;
        this.seatsNo = seatsNo;
        this.poName = poName;
        this.bookNumber = bookNumber;
        this.poNumber = poNumber;
        this.startAt = startAt;
        this.endAt = endAt;
        this.startCity = startCity;
        this.endCity = endCity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTerminal = startTerminal;
        this.endTerminal = endTerminal;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }


    public String getSeatsNo() {
        return seatsNo;
    }

    public void setSeatsNo(String seatsNo) {
        this.seatsNo = seatsNo;
    }


    public String getPoName() {
        return poName;
    }

    public void setPoName(String poName) {
        this.poName = poName;
    }


    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }


    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }


    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }


    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }


    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }


    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public String getStartTerminal() {
        return startTerminal;
    }

    public void setStartTerminal(String startTerminal) {
        this.startTerminal = startTerminal;
    }


    public String getEndTerminal() {
        return endTerminal;
    }

    public void setEndTerminal(String endTerminal) {
        this.endTerminal = endTerminal;
    }



    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
