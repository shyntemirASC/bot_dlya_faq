require: requirements.sc

theme: /
    
    init:
        
        bind("postProcess", function($context) {
            
            if ($context.currentState !== '/Start' && $context.currentState !== '/NoMatch' && $context.currentState !== '/SelectLanguage') {

                var flag = false;

                $context.response.replies.forEach(function(reply) {
                    if (reply.type === 'buttons') {
                        flag = true;
                        reply.buttons.push({ "text": getTranslation('back') });
                    }
                });

                if (!flag) {
                    $context.response.replies.push({
                        "type": "buttons",
                        "buttons": [ { "text": getTranslation('back') } ]
                    });
                }   
            }        
        });


  
    
    state: Start
        q!: $regex</start>
        a: Тілді тандаңыз/Пожалуйста, выберите язык
        buttons:
            "Русский" -> /Language/RU
            "Қазақша" -> /Language/KK

    state: AskName
        q!: как меня зовут
        script:
            if ($parseTree.text.length > "/start".length) {
                $session.startData = JSON.parse($parseTree.text.substr("/start".length + 1));
            }
        if: $session.startData
            a: Здравствуйте, {{$session.startData.name}}!
        else:
            a: Здравствуйте!

    state: NoMatch
        event!: noMatch
        a: {{ getTranslation(noMatch.mainMessage) }}
        buttons:
            "Алсеко" -> /Alseco/InitialState
            "{{ getTranslation('mainMenu.projects')}}" -> /Projects/InitialState


        # script:
        #     var result = $caila.cdqaQuery($request.query, "CDQA.test", 0.5);
        #     if (result.predicted) {
        #         $reactions.answer(result.predicted);
        #     } else {
        #         $reactions.answer("Я не нашел ответ в своих документах. Пожалуйста, спросите что-нибудь другое.");
        #     }
        


        #TEST интеграция ChatGPT
        # script:
        #     var userInput = $request.query
        #     var response = $http.post("https://api.openai.com/v1/chat/completions", {
        #         headers: {
        #             "Authorization": "Bearer OPENAPIKEY",
        #             "Content-Type": "application/json"
        #         },
        #         body: {
        #             "model": "gpt-3.5-turbo",
        #             "messages": [
        #                 { "role": "system", "content": "Ты - вежливый помощник в корпоративном боте. Отвечай кратко и понятно." },
        #                 { "role": "user", "content": userInput }
        #             ]
        #         }
        #     });

        #     $reactions.answer(toPrettyString(response));



