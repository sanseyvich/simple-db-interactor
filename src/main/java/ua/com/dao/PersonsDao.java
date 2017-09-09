package ua.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ua.com.persistence.Persons;

/**
 * Created by sanseyvich on 9/9/17.
 */
public class PersonsDao {
    private JdbcTemplate jdbcTemplate;

    public PersonsDao(JdbcTemplate jdbcTemplate) {
        setJdbcTemplate(jdbcTemplate);
    }

    public int savePersons(Persons persons) {
        String query = String.format(
                "insert into persons values(%d, '%s', '%s', '%s', '%s')",
                persons.getPersonid(),
                persons.getLastname(),
                persons.getFirstname(),
                persons.getAddress(),
                persons.getCity());
        return jdbcTemplate.update(query);
    }

    public int deletePersons(Persons persons) {
        String query = String.format("delete from persons where PersonID=%d", persons.getPersonid());
        return jdbcTemplate.update(query);
    }

    public Persons getPersonById(long id) {
        String query = String.format("select * from persons where PersonID=?");
        Persons person = jdbcTemplate.queryForObject(query,
                new Object[]{id}, new PersonsMapper());
        return person;

    }

    protected void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
