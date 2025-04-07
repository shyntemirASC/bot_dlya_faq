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

    state: NoMatch
        event!: noMatch
        a: {{ getTranslation(noMatch.mainMessage) }}
        buttons:
            "Алсеко" -> /Alseco/InitialState
            "{{ getTranslation('mainMenu.projects')}}" -> /Projects/InitialState


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



