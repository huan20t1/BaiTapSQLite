package com.example.crudsv.model;

public class Employee {
    public String getIdCom() {
        return idCom;
    }

    public void setIdCom(String idCom) {
        this.idCom = idCom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCate() {
        return idCate;
    }

    public void setIdCate(String idCate) {
        this.idCate = idCate;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Employee(String idCom, String name, String idCate, String des) {
        this.idCom = idCom;
        this.name = name;
        this.idCate = idCate;
        this.des = des;
    }

    private String idCom, name;
    private String idCate, des;

    public Employee() {
    }
}
