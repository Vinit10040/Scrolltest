package org.scrolltest.Helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.scrolltest.Constants.EndPoints;
import org.scrolltest.Models.Person;
import org.scrolltest.Utils.ConfigManager;
import java.lang.reflect.Type;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PersonServiceHelper {


    private static final String BASE_URI = ConfigManager.getInstance().getString("baseuri");

    private static final String PORT =  ConfigManager.getInstance().getString("port");

      public PersonServiceHelper(){
          RestAssured.baseURI = BASE_URI;
          RestAssured.port = Integer.parseInt(PORT);
          RestAssured.useRelaxedHTTPSValidation();
      }

      public List<Person> getAllPerson(){
          Response response = RestAssured.given().log().all().contentType(ContentType.JSON)
                  .get(EndPoints.GET_ALL_USER).andReturn();


         Type type = new  TypeReference<List<Person>>(){}.getType();
     assertEquals(response.getStatusCode(), HttpStatus.SC_OK,"OK");

          List<Person> personList = response.as(type);
          return personList;
      }

      public Response createPerson(){

          Person person = new Person();
          person.setFirstName("VinodS");
          person.setLastName("Shah");
          person.setSubjectId(57);
         // person.setId(52);

          Response response = RestAssured.given()
                  .contentType(ContentType.JSON)
                  .when()
                  .body(person)
                  .post(EndPoints.CREATE_USER).andReturn();
          assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED,"OK");
          return response;
      }

      public Response updatePerson(Integer id){

          Person person = new Person();
          person.setFirstName("bijal");
          person.setLastName("person");
          person.setSubjectId(78);
          Response response = RestAssured.given().contentType(ContentType.JSON)
                  .pathParam("id",id)
                  .when().body(person)
                  .patch(EndPoints.UPDATE_USER)
                  .andReturn();
          assertTrue(response.getStatusCode()==HttpStatus.SC_OK);
          return response;
      }

      public Response deletePerson(Integer id){
          Response response = RestAssured.given().contentType(ContentType.JSON)
                  .pathParam("id",id).log().all()
                  .when().delete(EndPoints.DELETE_SINGLE_USER)
                  .andReturn();
          assertTrue(response.getStatusCode()==HttpStatus.SC_OK);
          return response;
      }
        }



