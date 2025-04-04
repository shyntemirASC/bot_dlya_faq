theme: /MainMenu
    
    state: Init
        a: {{ getTranslation('welcomeMessage') }}         
        buttons:
            "Алсеко" -> /Alseco/InitialState
            "{{ getTranslation('')}}" -> /Projects/InitialState
    