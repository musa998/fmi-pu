Feature: BuyTikets feature
  Отговаря за Купуване на билет за събитие


  Scenario: Купуване на билет за дадено събитие с валидни данни
    Given потребителя отваря станицата на събитието
    And натиска върху бутона за купуване на билет
    And визуализира се форма за купуване на билети
    When избере някои от предоставените начини за плащане
    And въведе валиден имеѝл
    And натисне бутона за закуване
    Then вижда съобщение с текст "Успешно закупен!!!!"

  Scenario: Купуване на билет за дадено събитие без начин на плащане
    Given потребителя отваря станицата на събитието
    And натиска върху бутона за купуване на билет
    And визуализира се форма за купуване на билети
    When избере някои от предоставените начини за плащане
    And натисне бутона за закуване
    Then вижда съобщение с текст "Попълнете всички полета!!!!"

  Scenario: Купуване на билет за дадено събитие без начин на плащане и имеѝл
    Given потребителя отваря станицата на събитието
    And натиска върху бутона за купуване на билет
    And визуализира се форма за купуване на билети
    When въведе валиден имеѝл
    And натисне бутона за закуване
    Then вижда съобщение с текст "Попълнете всички полета!!!!"

  Scenario: Купуване на билет за дадено събитие без да попълва нищо
    Given потребителя отваря станицата на събитието
    And натиска върху бутона за купуване на билет
    And визуализира се форма за купуване на билети
    When натисне бутона за закуване
    Then вижда съобщение с текст "Попълнете всички полета!!!!"

  Scenario: Купуване на билет за дадено събитие с невалиден имеѝл
    Given потребителя отваря станицата на събитието
    And натиска върху бутона за купуване на билет
    And визуализира се форма за купуване на билети
    When въведе невалиден имеѝл
    And избере някои от предоставените начини за плащане
    And натисне бутона за закуване
    Then вижда съобщение с текст "Невалидни данни!!!!"


