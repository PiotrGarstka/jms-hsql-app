package com.example.nordeatask.dao;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.nordeatask.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Person findByName(String firstName) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("first_name", firstName);

        String sql = "SELECT * FROM person WHERE first_name=:first_name";

        Person result = namedParameterJdbcTemplate.queryForObject(
                sql,
                params,
                new UserMapper());

        //new BeanPropertyRowMapper(Customer.class));

        return result;

    }

    @Override
    public List<Person> findAll() {

        Map<String, Object> params = new HashMap<String, Object>();

        String sql = "SELECT * FROM person";

        List<Person> result = namedParameterJdbcTemplate.query(sql, params, new UserMapper());

        return result;

    }

    private static final class UserMapper implements RowMapper<Person> {

        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(BigInteger.valueOf(rs.getInt("id")));
            person.setEmail(rs.getString("email"));
            person.setFirstName(rs.getString("first_name"));
            person.setJoinedDate(rs.getDate("joined_date"));
            person.setLastName(rs.getString("last_name"));
            return person;
        }
    }



}
