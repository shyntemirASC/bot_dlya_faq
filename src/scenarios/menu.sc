theme: /MainMenu
    
    state: Init
        a: {{ getTranslation('mainMenu.welcomeMessage') }}         
        buttons:
            "Алсеко" -> /Alseco/InitialState
            "{{ getTranslation('mainMenu.projects')}}" -> /Projects/InitialState
    
    state: PreviousState
        intent!: /Back
        q: $regexp<^(Назад|Артқа)$>
        go!: /Start