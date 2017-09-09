package ua.com.dao;

import org.springframework.jdbc.core.RowMapper;
import ua.com.persistence.Persons;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sanseyvich on 9/9/17.
 */
public class PersonsMapper implements RowMapper<Persons> {
    public Persons mapRow(ResultSet rs, int rowNum) throws SQLException {
        Persons persons = new Persons();
        persons.setPersonid(rs.getLong("PersonID"));
        persons.setLastname(rs.getString("LastName"));
        persons.setFirstname(rs.getString("FirstName"));
        persons.setAddress(rs.getString("Address"));
        persons.setCity(rs.getString("City"));
        return persons;
    }
}
