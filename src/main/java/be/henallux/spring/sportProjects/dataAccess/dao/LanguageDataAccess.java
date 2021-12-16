package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.model.Language;

public interface LanguageDataAccess {
    Language getLanguageWithInternationalCode(String internationalCode);
}
