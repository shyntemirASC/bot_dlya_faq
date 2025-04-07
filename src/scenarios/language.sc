theme: /Language

    state: RU
        intent!: /ChangeLanguage

        script:
            $client.selectedLanguage = 'ru'
        a: {{ getTranslation('language.changedMessage') }}
        go!: /MainMenu/Init
        
    
    state: KK
        intent!: /ChangeLanguage

        script:
            $client.selectedLanguage = 'kk'
        a: {{ getTranslation('language.changedMessage') }}
        go!: /MainMenu/Init