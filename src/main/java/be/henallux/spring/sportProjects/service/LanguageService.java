package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.LanguageDataAccess;
import be.henallux.spring.sportProjects.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    private LanguageDataAccess languageDataAccess;

    @Autowired
    public LanguageService(LanguageDataAccess languageDataAccess) {
        this.languageDataAccess = languageDataAccess;
    }

    public Language getLanguageWithInternationalCode(String internationalCode) {
        return languageDataAccess.getLanguageWithInternationalCode(internationalCode);
    }
}
