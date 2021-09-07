package stepsDefinitions.ConsultaPets;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static net.serenitybdd.rest.SerenityRest.given;

public class ConsultaPets {

    private static RequestSpecification requestSpec;
    private static HashMap<String, Object> headerMap;
    public static void getPets(String idmascota) {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io")
                .build();
        headerMap = new HashMap<>();
        headerMap.get("accept: application/json");

        given().
                log().all().
                spec(requestSpec).
                headers(headerMap).
                pathParam("petId", idmascota).
                when().
                get("v2/pet/{petId}").
                then().
                and().
                log().all();


    }

    }

