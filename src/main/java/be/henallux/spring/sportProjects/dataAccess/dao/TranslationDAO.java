package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.dataAccess.entity.TranslationEntity;
import be.henallux.spring.sportProjects.dataAccess.repository.TranslationRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationDAO implements TranslationDataAccess{
    private TranslationRepository translationRepository;
    private ProviderConverter converter;

    @Autowired
    public TranslationDAO(TranslationRepository translationRepository, ProviderConverter converter) {
        this.translationRepository = translationRepository;
        this.converter = converter;
    }

    @Override
    public Translation getTranslationWithProductIdAndLanguageId(Integer idProduct, Integer idLanguage) {
        TranslationEntity translationEntity = translationRepository.findTranslationEntityByTranslationId_ProductAndTranslationId_Language(idProduct, idLanguage);
        Translation translation = converter.translationEntityToTranslationModel(translationEntity);
        return translation;
    }
}
