package com.example.a20520322_lab02;

public class PesonalSalary {
    private String FullName;
    private long Salary;
    public PesonalSalary(){}
    public PesonalSalary(String fullName, long salary) {
        FullName = fullName;
        Salary = salary;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public long getSalary() {
        return Salary;
    }

    public void setSalary(long salary) {
        Salary = salary;
    }

    public String toString(){
        return "Full Name: "+ FullName +"\n"+"Net Salary: " + Salary;
    }

}
