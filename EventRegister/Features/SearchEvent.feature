Feature: Search feature
  Отговаря за  търсене на събитие по име


  Scenario: Търсене в системата с валидни входни данни
    Given потребителя отваря началната страница
    And натиска върху бутона за търсене в системата
    And визуализира се форма за търсене в системата
    When въведе валидни входни данни за търсене
    And натисне бутона за търсене
    Then вижда съобщение "Намерено!!!!"

  Scenario: Търсене в системата с невалидни входни данни
    Given потребителя отваря началната страница
    And натиска върху бутона за търсене в системата
    And визуализира се форма за търсене в системата
    When въведе невалидни входни данни за търсене
    And натисне бутона за търсене
    Then вижда съобщение "Невалидни входни данни!!!!"

  Scenario: Търсене в системата без входни данни
    Given потребителя отваря началната страница
    And натиска върху бутона за търсене в системата
    And визуализира се форма за търсене в системата
    When натисне бутона за търсене
    Then вижда съобщение "Липса на входни данни!!!!"
