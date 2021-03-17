package org.scrolltest.test;

import org.junit.BeforeClass;
import org.scrolltest.Helpers.PersonServiceHelper;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestPostPersom {

  //private PersonServiceHelper personServiceHelper;
    PersonServiceHelper personServiceHelper = new PersonServiceHelper();

    @BeforeClass
    public void init(){
      personServiceHelper = new PersonServiceHelper();


    }
    @Test
    public void createPersonPost()
    {
        try
        {
            String id = personServiceHelper.createPerson().jsonPath().getString("id");
            System.out.println(id);
            assertNotNull(id,"person id is not empty");

        }catch (Exception e){
            System.out.println(e);
        }
       // String id = personServiceHelper.createPerson().jsonPath().getString("id");

    }
}
