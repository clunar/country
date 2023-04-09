Feature: Crear países

  Scenario: Crear país Asgard
    * header content-type = 'application/json'
    Given url "http://api.countrylayer.com/v2?access_key=5354cfd259c18ce25de2d0b97ceb9923"
    And def data = read('classpath:../country/dataCountry.json')
    And request data
    When method post
    Then status 201
    And print response
    And match response.name contains "Asgard"