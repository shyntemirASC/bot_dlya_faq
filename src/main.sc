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
        a: {{ getTranslation('noMatch.mainMessage') }}
        buttons:
            "Алсеко" -> /Alseco/InitialState
            "{{ getTranslation('mainMenu.projects')}}" -> /Projects/InitialState

