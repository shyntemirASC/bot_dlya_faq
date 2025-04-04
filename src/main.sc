require: requirements.sc

theme: /
    
    init:
        
        bind("postProcess", function($context) {
            
            if ($context.currentState !== '/Start' && $context.currentState !== '/NoMatch' && $context.currentState !== '/SelectLanguage') {

                var flag = false;

                $context.response.replies.forEach(function(reply) {
                    if (reply.type === 'buttons') {
                        flag = true;
                        reply.buttons.push({ "text": $context.session.language === 'kk' ? "Артқа" : "Назад"});
                    }
                });

                if (!flag) {
                    $context.response.replies.push({
                        "type": "buttons",
                        "buttons": [ { "text": $context.session.language === 'kk' ? "Артқа" : "Назад" } ]
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
        a: Извините Я не понял ваш запрос. Пожалуйста, выберите вопрос которому нужен ответ в меню ниже:
        buttons:
            "Алсеко" -> /Alseco/InitialState 
            "Какие проекты имеются на данный момент?" -> /Projects/InitialState

