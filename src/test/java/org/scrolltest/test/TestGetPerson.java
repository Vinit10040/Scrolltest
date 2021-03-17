package org.scrolltest.test;

import org.junit.BeforeClass;
import org.scrolltest.Helpers.PersonServiceHelper;
import org.scrolltest.Models.Person;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.*;

public class TestGetPerson {
    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();

    }
    @Test
    public void testGetAllPerson(){

        List<Person> personList = personServiceHelper.getAllPerson();
        assertNotNull(personList,"person list is not empty");
        assertFalse(personList.isEmpty(),"person list is not true ");



    }

}
