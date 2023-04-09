@ignore
Feature: Obtener países

  Scenario: Obtener país con código US
    Given url "http://api.countrylayer.com/v2/alpha/US?access_key=5354cfd259c18ce25de2d0b97ceb9923"
    When method get
    Then status 200
    And print response
    And match response.name contains "United States of America"

  Scenario: Obtener país con código DE
    Given url "http://api.countrylayer.com/v2/alpha/DE?access_key=5354cfd259c18ce25de2d0b97ceb9923"
    When method get
    Then status 200
    And print response
    And match response.name contains "Germany"

  Scenario: Obtener país con código GB
    Given url "http://api.countrylayer.com/v2/alpha/GB?access_key=5354cfd259c18ce25de2d0b97ceb9923"
    When method get
    Then status 200
    And print response
    And match response.name contains "United Kingdom of Great Britain and Northern Ireland"

  Scenario: Obtener país inexistente
    Given url "http://api.countrylayer.com/v2/alpha/AGR?access_key=5354cfd259c18ce25de2d0b97ceb9923"
    When method get
    Then status 404
    And print response
    And match response.message contains "Not Found"