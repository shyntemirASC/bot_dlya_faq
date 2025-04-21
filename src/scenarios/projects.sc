theme: /Projects
    
    state: InitialState
        a: {{ getTranslation('projects.chooseProject') }} 
        buttons:
            "Бот "Инара"" -> /Projects/Inara
            "{{ getTranslation('projects.button1') }}" -> /Projects/Meter
            "{{ getTranslation('projects.button2') }}" -> /Projects/Serial
            
            
    state: PreviousState
        intent!: /Back
        q: $regexp<^(Назад|Артқа)$>
        go!: /MainMenu/Init
    
    state: Inara
        intent!: /WantsToAskAboutBot
        a: {{ getTranslation('projects.Inara') }}
            
        state: PreviousState
            intent!: /Back
            q: $regexp<^(Назад|Артқа)$>
            go!: /Projects/InitialState
        
    state: Meter
        a: {{ getTranslation('projects.firstProject') }}

        state: PreviousState
            intent!: /Back
            q: $regexp<^(Назад|Артқа)$>
            go!: /Projects/InitialState
            
    state: Serial
        a: {{ getTranslation('projects.secondProject') }}        
        state: PreviousState
            intent!: /Back
            q: $regexp<^(Назад|Артқа)$>
            go!: /Projects/InitialState