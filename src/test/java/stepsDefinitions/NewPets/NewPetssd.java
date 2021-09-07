package stepsDefinitions.NewPets;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;

import steps.NewPets.NewPets;
import steps.NewPets.PetsCustomer;
import stepsDefinitions.ConsultaPets.ConsultaPets;

import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;



public class NewPetssd {


 @Steps
 public NewPets newPets;

 @Before
 public void setTheStage() {
  OnStage.setTheStage(new OnlineCast());
 }

 @Given("El api este operativo")
 public void elApiEsteOperativo() {
 }


 @Then("valida que la respuesta sea {int}")
 public void validaQueLaRespuestaSea(int status) {
  assertThat(lastResponse().statusCode(), is(status));
 }

 @When("Registrar la mascota  {int} {string} {string} {string} {int} {string} {string}")
 public void registrarLaMascotaId_categoryIdtags(Integer id_category, String name_category, String name, String photoUrls, Integer idtags, String nametags, String status) {
  NewPets.registrarMascota(id_category, name_category, name, photoUrls, idtags, nametags, status);
 }


 @And("verifica el response de la respuesta")
 public void verificaElResponseDeLaRespuesta() {

 }

 @And("verifica el response de la respuesta {int} {string} {string} {string}")
 public void verificaElResponseDeLaRespuesta(Integer id_category, String name_category, String name, String status) {
  assertThat(lastResponse().getBody().path("category.id"), equalTo(id_category));
  assertThat(lastResponse().getBody().path("category.name"), equalTo(name_category));
  assertThat(lastResponse().getBody().path("name"), equalTo(name));
  assertThat(lastResponse().getBody().path("status"), equalTo(status));


 }


 @When("Realiza la consulta  {string}")
 public void realizaLaConsultaId_mascota(String idmascota) {
  ConsultaPets.getPets(idmascota);
 }

 @When("se realiza la actualizacion de {string} ,{string}, {string}")
 public void seRealizaLaActualizacionDe(String idmascota, String name, String status) throws IOException {
  NewPets.UpdatesPetsData(idmascota,name,status);
 }




 @Then("verifica el response de la consulta {string} {string} {string} {string}")
 public void verificaElResponseDeLaConsulta(String idmascota, String name, String name_category,String status) {

  assertThat(lastResponse().getBody().path("id"), equalTo(idmascota));
  assertThat(lastResponse().getBody().path("category.name"), equalTo(name));
  assertThat(lastResponse().getBody().path("name"), equalTo(name_category));
  assertThat(lastResponse().getBody().path("status"), equalTo(status));


 }

 @Then("validar que la actualización por el petId  sea {string}")
 public void validarQueLaActualizaciónPorElPetIdSea(String idmascota) {
  assertThat(lastResponse().getBody().path("message"), equalTo(idmascota));

 }
}







