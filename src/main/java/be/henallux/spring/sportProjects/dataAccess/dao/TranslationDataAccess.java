package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.model.Translation;

public interface TranslationDataAccess {
    Translation getTranslationWithProductIdAndLanguageId(Integer idProduct, Integer idLanguage);
}
