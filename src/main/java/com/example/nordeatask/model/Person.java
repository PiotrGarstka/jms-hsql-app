package com.example.nordeatask.model;

import java.math.BigInteger;
import java.util.Date;

public class Person {

    BigInteger id;
    String email;
    String firstName;
    Date joinedDate;
    String lastName;

    public Person(String first_name, BigInteger id) {
        this.firstName=first_name;
        this.id=id;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", joinedDate=" + joinedDate +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
