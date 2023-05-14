package com.example.model;

public class Student {
    private  int id ;
    private  String name ;
    private Clazz clazz;
    private Float point ;

    public Student() {
    }

    public Student(int id, String name, Clazz clazz, Float point) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.point = point;
    }

    public Student(String name, Clazz clazz, Float point) {
        this.name = name;
        this.clazz = clazz;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }
}
