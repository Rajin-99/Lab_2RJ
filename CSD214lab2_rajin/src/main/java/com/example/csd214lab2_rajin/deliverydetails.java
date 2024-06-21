package com.example.csd214lab2_rajin;

public class deliverydetails {

    private int sn;

    private String fname;

    private String address;

    private String zipcode;

    public deliverydetails(int sn, String fname, String address, String zipcode) {
        this.sn = sn;
        this.fname = fname;
        this.address = address;
        this.zipcode = zipcode;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}