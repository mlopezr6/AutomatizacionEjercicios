@Mascota
Feature: Registrar Mascota

  @NuevaMascota
 Scenario Outline: Nueva mascota
    Given El api este operativo
    When Registrar la mascota  <id_category> "<name_category>" "<name>" "<photoUrls>" <idtags> "<nametags>" "<status>"
    Then valida que la respuesta sea 200
    And verifica el response de la respuesta <id_category> "<name_category>" "<name>" "<status>"

    Examples:
    |id_category|name_category|name|photoUrls|idtags|nametags| status|
    |003|Boxer|Otto|Sin_foto |1     |Prueba  |available|
    |004|Maltes|Chato|Sin_foto |2     |Pequeño  |available|

  Scenario Outline: Consultar mascota
    Given El api este operativo
    When Realiza la consulta  "<idmascota>"
    Then valida que la respuesta sea 200
   Then verifica el response de la consulta "<idmascota>" "<name_category>" "<name>" "<status>"
    Examples:
      |idmascota|name_category|name|status|
      |9223372000666114267|Boxer|Otto|available|


  Scenario Outline: Modificar mascota
    Given El api este operativo
    When  se realiza la actualizacion de "<idmascota>" ,"<name>", "<status>"
    Then  valida que la respuesta sea 200
    Then  validar que la actualización por el petId  sea "<idmascota>"
    Examples:
      |idmascota|name|status|
      |9223372000666114293|Maltes|disable|





