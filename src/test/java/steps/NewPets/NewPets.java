package steps.NewPets;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import steps.UpdatePets.UpdatesPets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static net.serenitybdd.rest.SerenityRest.given;

public class NewPets {
    private static RequestSpecification requestSpec;
    private static HashMap<String, Object> headerMap;
    private Map<String,Object> jsonAsMap;


    public static void registrarMascota(Integer id_category, String name_category, String name, String photoUrls, Integer idtags, String nametags, String status) {
        List<Tags> tagsList = new ArrayList<>();
        Tags tags = new Tags(idtags, nametags);
        tagsList.add(tags);
        List<String> photoUrlsList = new ArrayList<>();
        photoUrlsList.add(photoUrls);


        PetsCustomer petsCustomer = new PetsCustomer();

        Category category = new Category();
        petsCustomer.setId(0);
        category.setId(id_category);
        category.setName(name_category);
        petsCustomer.setName(name);
        petsCustomer.setPhotoUrls(photoUrlsList);

        petsCustomer.setStatus(status);
        petsCustomer.setCategory(category);
        petsCustomer.setTags(tagsList);


        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io")
                .build();
        headerMap = new HashMap<>();

        headerMap.put("accept", "application/json");
        headerMap.put("Content-Type", "application/json");


        given().
                log().all().
                spec(requestSpec).
                headers(headerMap).
                body(petsCustomer).
                when().
                    post("v2/pet/").
                then().
                and().
                log().all();


    }


    public static void UpdatesPetsData(String idmascota, String name, String status)throws IOException {


        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io")
                .build();
        headerMap = new HashMap<>();

        headerMap.put("accept", "application/json");
        headerMap.put("Content-Type", "application/x-www-form-urlencoded");
        headerMap.put("name",name);
        headerMap.put("status",status);



        given().
                log().all().
                spec(requestSpec).
                headers(headerMap).
                pathParam("petId",idmascota).
        when().
                post("v2/pet/{petId}").

        then().
         and().
         log().all();


    }
}





