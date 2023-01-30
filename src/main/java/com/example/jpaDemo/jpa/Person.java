package com.example.jpaDemo.jpa;

import jakarta.persistence.*;

@Entity //Creates a mapping between the bean and the table
@NamedQuery(name = "find_all_persons", query = "select p from Person p")
//@Table(name = "person")  //This optional, JPA will automatically match to the table in DB
public class Person {

    @Id     //@Id indicates that this is a primary key
    @GeneratedValue  //@GeneratedValue >>If you need hibernate to take control of generating the id and don't want to manually set the id
                    //When you insert a new row you want hibernate to crete a Id
    private int id;

    @Column(name = "name") //This also optional
    private String name;
    private String location;

    //With hibernate you need to have a no arguments constructor
    public Person() {
    }
    public Person(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Person(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
