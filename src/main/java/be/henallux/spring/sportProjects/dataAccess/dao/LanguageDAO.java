package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.dataAccess.entity.LanguageEntity;
import be.henallux.spring.sportProjects.dataAccess.repository.LanguageRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageDAO implements LanguageDataAccess{
    private LanguageRepository languageRepository;
    private ProviderConverter converter;

    @Autowired
    public LanguageDAO(LanguageRepository languageRepository, ProviderConverter converter) {
        this.languageRepository = languageRepository;
        this.converter = converter;
    }

    @Override
    public Language getLanguageWithInternationalCode(String internationalCode) {
        LanguageEntity languageEntity = languageRepository.findLanguageEntityByInternationCode(internationalCode);
        Language language = converter.languageEntityToLanguageModel(languageEntity);
        return language;
    }
}
