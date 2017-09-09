package ua.com;

import ua.com.dao.PersonsDao;
import ua.com.persistence.Persons;

/**
 * Created by sanseyvich on 9/9/17.
 */
public class PersonsTest {
    public static void main(String[] args) {
        Persons valera = new Persons();
        valera.setAddress("Kolibabunska 100500 / 2");
        valera.setCity("Boyarka");
        valera.setFirstname("Valera");
        valera.setLastname("Babenko");
        valera.setPersonid(2l);

        PersonsDao personsDao = new PersonsDao(new JdbcTemplateFactory().createMysqlJdbcPool());

        personsDao.savePersons(valera);

        Persons valera_1 = personsDao.getPersonById(valera.getPersonid());
        assert valera.getLastname() == valera_1.getLastname();
        assert valera.getPersonid() == valera_1.getPersonid();

        //cleanup
        personsDao.deletePersons(valera);
    }

}
