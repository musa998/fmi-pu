$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BuyTickets.feature");
formatter.feature({
  "line": 1,
  "name": "BuyTikets feature",
  "description": "Отговаря за Купуване на билет за събитие",
  "id": "buytikets-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Купуване на билет за дадено събитие с валидни данни",
  "description": "",
  "id": "buytikets-feature;купуване-на-билет-за-дадено-събитие-с-валидни-данни",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "потребителя отваря станицата на събитието",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "натиска върху бутона за купуване на билет",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "визуализира се форма за купуване на билети",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "избере някои от предоставените начини за плащане",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "въведе валиден имеѝл",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "натисне бутона за закуване",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "вижда съобщение с текст \"Успешно закупен!!!!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BuyTicketSteps.потребителя_отваря_станицата_на_събитието()"
});
formatter.result({
  "duration": 148166757,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.натиска_върху_бутона_за_купуване_на_билет()"
});
formatter.result({
  "duration": 59247,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.визуализира_се_форма_за_купуване_на_билети()"
});
formatter.result({
  "duration": 8007173,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.избере_някои_от_предоставените_начини_за_плащане()"
});
formatter.result({
  "duration": 50383,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.въведе_валиден_имеѝл()"
});
formatter.result({
  "duration": 47584,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.натисне_бутона_за_закуване()"
});
formatter.result({
  "duration": 107590207,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Успешно закупен!!!!",
      "offset": 25
    }
  ],
  "location": "BuyTicketSteps.вижда_съобщение_с_текст(String)"
});
formatter.result({
  "duration": 3981194,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Купуване на билет за дадено събитие без начин на плащане",
  "description": "",
  "id": "buytikets-feature;купуване-на-билет-за-дадено-събитие-без-начин-на-плащане",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "потребителя отваря станицата на събитието",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "натиска върху бутона за купуване на билет",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "визуализира се форма за купуване на билети",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "избере някои от предоставените начини за плащане",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "натисне бутона за закуване",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "вижда съобщение с текст \"Попълнете всички полета!!!!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BuyTicketSteps.потребителя_отваря_станицата_на_събитието()"
});
formatter.result({
  "duration": 54115,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.натиска_върху_бутона_за_купуване_на_билет()"
});
formatter.result({
  "duration": 36388,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.визуализира_се_форма_за_купуване_на_билети()"
});
formatter.result({
  "duration": 32655,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.избере_някои_от_предоставените_начини_за_плащане()"
});
formatter.result({
  "duration": 31723,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.натисне_бутона_за_закуване()"
});
formatter.result({
  "duration": 55515,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Попълнете всички полета!!!!",
      "offset": 25
    }
  ],
  "location": "BuyTicketSteps.вижда_съобщение_с_текст(String)"
});
formatter.result({
  "duration": 90037,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Купуване на билет за дадено събитие без начин на плащане и имеѝл",
  "description": "",
  "id": "buytikets-feature;купуване-на-билет-за-дадено-събитие-без-начин-на-плащане-и-имеѝл",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "потребителя отваря станицата на събитието",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "натиска върху бутона за купуване на билет",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "визуализира се форма за купуване на билети",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "въведе валиден имеѝл",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "натисне бутона за закуване",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "вижда съобщение с текст \"Попълнете всички полета!!!!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BuyTicketSteps.потребителя_отваря_станицата_на_събитието()"
});
formatter.result({
  "duration": 53182,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.натиска_върху_бутона_за_купуване_на_билет()"
});
formatter.result({
  "duration": 26125,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.визуализира_се_форма_за_купуване_на_билети()"
});
formatter.result({
  "duration": 24258,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.въведе_валиден_имеѝл()"
});
formatter.result({
  "duration": 27991,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.натисне_бутона_за_закуване()"
});
formatter.result({
  "duration": 22859,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Попълнете всички полета!!!!",
      "offset": 25
    }
  ],
  "location": "BuyTicketSteps.вижда_съобщение_с_текст(String)"
});
formatter.result({
  "duration": 94701,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Купуване на билет за дадено събитие без да попълва нищо",
  "description": "",
  "id": "buytikets-feature;купуване-на-билет-за-дадено-събитие-без-да-попълва-нищо",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "потребителя отваря станицата на събитието",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "натиска върху бутона за купуване на билет",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "визуализира се форма за купуване на билети",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "натисне бутона за закуване",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "вижда съобщение с текст \"Попълнете всички полета!!!!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BuyTicketSteps.потребителя_отваря_станицата_на_събитието()"
});
formatter.result({
  "duration": 58781,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.натиска_върху_бутона_за_купуване_на_билет()"
});
formatter.result({
  "duration": 24725,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.визуализира_се_форма_за_купуване_на_билети()"
});
formatter.result({
  "duration": 26125,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.натисне_бутона_за_закуване()"
});
formatter.result({
  "duration": 24258,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Попълнете всички полета!!!!",
      "offset": 25
    }
  ],
  "location": "BuyTicketSteps.вижда_съобщение_с_текст(String)"
});
formatter.result({
  "duration": 94235,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "Купуване на билет за дадено събитие с невалиден имеѝл",
  "description": "",
  "id": "buytikets-feature;купуване-на-билет-за-дадено-събитие-с-невалиден-имеѝл",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 38,
  "name": "потребителя отваря станицата на събитието",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "натиска върху бутона за купуване на билет",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "визуализира се форма за купуване на билети",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "въведе невалиден имеѝл",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "избере някои от предоставените начини за плащане",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "натисне бутона за закуване",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "вижда съобщение с текст \"Невалидни данни!!!!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BuyTicketSteps.потребителя_отваря_станицата_на_събитието()"
});
formatter.result({
  "duration": 59713,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.натиска_върху_бутона_за_купуване_на_билет()"
});
formatter.result({
  "duration": 32189,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.визуализира_се_форма_за_купуване_на_билети()"
});
formatter.result({
  "duration": 35921,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.въведе_невалиден_имеѝл()"
});
formatter.result({
  "duration": 34989,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.избере_някои_от_предоставените_начини_за_плащане()"
});
formatter.result({
  "duration": 34521,
  "status": "passed"
});
formatter.match({
  "location": "BuyTicketSteps.натисне_бутона_за_закуване()"
});
formatter.result({
  "duration": 265910,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Невалидни данни!!!!",
      "offset": 25
    }
  ],
  "location": "BuyTicketSteps.вижда_съобщение_с_текст(String)"
});
formatter.result({
  "duration": 100766,
  "status": "passed"
});
formatter.uri("SearchEvent.feature");
formatter.feature({
  "line": 1,
  "name": "Search feature",
  "description": "Отговаря за  търсене на събитие по име",
  "id": "search-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Търсене в системата с валидни входни данни",
  "description": "",
  "id": "search-feature;търсене-в-системата-с-валидни-входни-данни",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "потребителя отваря началната страница",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "натиска върху бутона за търсене в системата",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "визуализира се форма за търсене в системата",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "въведе валидни входни данни за търсене",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "натисне бутона за търсене",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "вижда съобщение \"Намерено!!!!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchSteps.потребителя_отваря_началната_страница()"
});
formatter.result({
  "duration": 123625,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.натиска_върху_бутона_за_търсене_в_системата()"
});
formatter.result({
  "duration": 65778,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.визуализира_се_форма_за_търсене_в_системата()"
});
formatter.result({
  "duration": 45718,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.въведе_валидни_входни_данни_за_търсене()"
});
formatter.result({
  "duration": 54115,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.натисне_бутона_за_търсене()"
});
formatter.result({
  "duration": 3130281,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Намерено!!!!",
      "offset": 17
    }
  ],
  "location": "SearchSteps.вижда_съобщение(String)"
});
formatter.result({
  "duration": 97034,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Търсене в системата с невалидни входни данни",
  "description": "",
  "id": "search-feature;търсене-в-системата-с-невалидни-входни-данни",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "потребителя отваря началната страница",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "натиска върху бутона за търсене в системата",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "визуализира се форма за търсене в системата",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "въведе невалидни входни данни за търсене",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "натисне бутона за търсене",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "вижда съобщение \"Невалидни входни данни!!!!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchSteps.потребителя_отваря_началната_страница()"
});
formatter.result({
  "duration": 63445,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.натиска_върху_бутона_за_търсене_в_системата()"
});
formatter.result({
  "duration": 30790,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.визуализира_се_форма_за_търсене_в_системата()"
});
formatter.result({
  "duration": 33122,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.въведе_невалидни_входни_данни_за_търсене()"
});
formatter.result({
  "duration": 47584,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.натисне_бутона_за_търсене()"
});
formatter.result({
  "duration": 95634,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Невалидни входни данни!!!!",
      "offset": 17
    }
  ],
  "location": "SearchSteps.вижда_съобщение(String)"
});
formatter.result({
  "duration": 83505,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Търсене в системата без входни данни",
  "description": "",
  "id": "search-feature;търсене-в-системата-без-входни-данни",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "потребителя отваря началната страница",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "натиска върху бутона за търсене в системата",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "визуализира се форма за търсене в системата",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "натисне бутона за търсене",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "вижда съобщение \"Липса на входни данни!!!!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchSteps.потребителя_отваря_началната_страница()"
});
formatter.result({
  "duration": 103098,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.натиска_върху_бутона_за_търсене_в_системата()"
});
formatter.result({
  "duration": 25191,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.визуализира_се_форма_за_търсене_в_системата()"
});
formatter.result({
  "duration": 23792,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.натисне_бутона_за_търсене()"
});
formatter.result({
  "duration": 40120,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Липса на входни данни!!!!",
      "offset": 17
    }
  ],
  "location": "SearchSteps.вижда_съобщение(String)"
});
formatter.result({
  "duration": 83505,
  "status": "passed"
});
});