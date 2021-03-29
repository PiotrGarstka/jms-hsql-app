package com.example.nordeatask.dao;

import com.example.nordeatask.model.Person;

import java.util.List;

public interface PersonDao {

    Person findByName(String firstName);

    List<Person> findAll();

}
