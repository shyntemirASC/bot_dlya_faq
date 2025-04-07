function getTranslation(key) {
    var keys = key.split('.');
    
    var translation = translations[$jsapi.context().client.selectedLanguage];
    for (var i = 0; i < keys.length; i++) {
        translation = translation[keys[i]];
    }
    return translation;
}