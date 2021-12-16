package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.TranslationDataAccess;
import be.henallux.spring.sportProjects.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {
    private TranslationDataAccess translationDataAccess;
    private Translation translation;

    @Autowired
    public TranslationService(TranslationDataAccess translationDataAccess) {
        this.translationDataAccess = translationDataAccess;
    }

    public Translation getTranslationWithProductIdAndLanguageId(Integer idProduct, Integer idLanguage) {
        translation = translationDataAccess.getTranslationWithProductIdAndLanguageId(idProduct, idLanguage);
        return translation;
    }

}
