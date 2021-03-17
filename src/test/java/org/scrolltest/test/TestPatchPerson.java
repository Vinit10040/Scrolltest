package org.scrolltest.test;

import org.scrolltest.Helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestPatchPerson {

    PersonServiceHelper personServiceHelper = new PersonServiceHelper();

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();


    }
    @Test
    public void updatePersondata(){
        String id = personServiceHelper.updatePerson(2).jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id,"Updated");
    }
}
