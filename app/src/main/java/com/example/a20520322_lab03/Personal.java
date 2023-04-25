package com.example.a20520322_lab03;

public class Personal {
    private int Id;
    private String FullName;

    public Personal(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    private String Phone;


    public Personal(int id, String fullName, String phone) {
        Id = id;
        FullName = fullName;
        Phone = phone;
    }
    public String toString(){
        return "Full Name: "+ FullName +", "+"Phone: " + Phone;
    }

}
