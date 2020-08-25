package pl.lomza.programowanie.rozliczenie_pojazdu_rest_jdbc.common;

import java.time.LocalDate;

public class Ride {
    private long id;
    private LocalDate rideDate;
    private int counterBefore;
    private int counterAfter;
    private int km;
    private String whence;
    private String where;
    private String rideKind;
    private double fuelCondition;
    private double fuelAdd;
    private double fuelAfter;
    private Double fuel;
    private Double price;
    private Double currency;
    private double fuelNorm;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getRideDate() {
        return rideDate;
    }

    public void setRideDate(LocalDate rideDate) {
        this.rideDate = rideDate;
    }

    public int getCounterBefore() {
        return counterBefore;
    }

    public void setCounterBefore(int counterBefore) {
        this.counterBefore = counterBefore;
    }

    public int getCounterAfter() {
        return counterAfter;
    }

    public void setCounterAfter(int counterAfter) {
        this.counterAfter = counterAfter;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getWhence() {
        return whence;
    }

    public void setWhence(String whence) {
        this.whence = whence;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getRideKind() {
        return rideKind;
    }

    public void setRideKind(String rideKind) {
        this.rideKind = rideKind;
    }

    public double getFuelCondition() {
        return fuelCondition;
    }

    public void setFuelCondition(double fuelCondition) {
        this.fuelCondition = fuelCondition;
    }

    public double getFuelAdd() {
        return fuelAdd;
    }

    public void setFuelAdd(double fuelAdd) {
        this.fuelAdd = fuelAdd;
    }

    public double getFuelAfter() {
        return fuelAfter;
    }

    public void setFuelAfter(double fuelAfter) {
        this.fuelAfter = fuelAfter;
    }

    public Double getFuel() {
        return fuel;
    }

    public void setFuel(Double fuel) {
        this.fuel = fuel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCurrency() {
        return currency;
    }

    public void setCurrency(Double currency) {
        this.currency = currency;
    }

    public double getFuelNorm() {
        return fuelNorm;
    }

    public void setFuelNorm(double fuelNorm) {
        this.fuelNorm = fuelNorm;
    }
}
