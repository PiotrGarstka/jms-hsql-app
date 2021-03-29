package com.example.nordeatask;
import com.example.nordeatask.dao.PersonDao;
import com.example.nordeatask.dao.PersonDaoImpl;
import com.example.nordeatask.model.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class UserDaoTest {

    private EmbeddedDatabase db;
    PersonDao personDao;

    @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/sql/create-db.sql")
                .addScript("db/sql/insert-data.sql")
                .build();
    }

    @Test
    public void testFindByname() {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
        PersonDaoImpl personDao = new PersonDaoImpl();
        personDao.setNamedParameterJdbcTemplate(template);

        Person person = personDao.findByName("piotr");

        Assert.assertNotNull(person);
        Assert.assertEquals(1, person.getId().intValue());
        Assert.assertEquals("piotr", person.getFirstName());
        Assert.assertEquals("piotr@gmail.com", person.getEmail());

    }

    @After
    public void tearDown() {
        db.shutdown();
    }


}
