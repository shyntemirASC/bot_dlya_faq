theme: /Alseco
    
    state: InitialState
        a: {{ getTranslation('alseco.mainMessage') }}
        buttons:
            "{{ getTranslation('alseco.button1') }}" -> /Alseco/Perks
            "{{ getTranslation('alseco.button2') }}" -> /Alseco/Company
            "{{ getTranslation('alseco.button3') }}" -> /Alseco/Comfort
            
    state: PreviousState
        q: $regexp<^(Назад|Артқа)$>
        go!: /MainMenu/Init

    state: Perks
        a: {{ getTranslation('alseco.perks') }}
        
        state: PreviousState
            q: $regexp<^(Назад|Артқа)$>
            go!: /Alseco/InitialState
            
    state: Company
        intent!: /WantsToKnowAboutAlseco
        a: {{ getTranslation('alseco.about') }}
        
        state: PreviousState
            q: $regexp<^(Назад|Артқа)$>
            go!: /Alseco/InitialState

    state: Comfort
        a: {{ getTranslation('alseco.comfort') }}

        state: PreviousState
            q: $regexp<^(Назад|Артқа)$>
            go!: /Alseco/InitialState