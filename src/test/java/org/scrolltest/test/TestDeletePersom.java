package org.scrolltest.test;

import org.scrolltest.Helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDeletePersom {

    PersonServiceHelper personServiceHelper = new PersonServiceHelper();

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();


    }

    @Test
    public void deletePerson(){
        personServiceHelper.deletePerson(3);
    }
}
