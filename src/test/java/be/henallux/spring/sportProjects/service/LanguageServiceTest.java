package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.LanguageDAO;
import be.henallux.spring.sportProjects.dataAccess.dao.LanguageDataAccess;
import be.henallux.spring.sportProjects.dataAccess.entity.LanguageEntity;
import be.henallux.spring.sportProjects.dataAccess.repository.LanguageRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.Language;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class LanguageServiceTest {
    @Mock
    private LanguageRepository languageRepository;

    private LanguageDataAccess languageDAO;
    private ProviderConverter providerConverter;

    @Before
    public void setUp() {
        providerConverter = new ProviderConverter();
        languageDAO = new LanguageDAO(languageRepository, providerConverter);
    }

    @Test
    public void getLanguageWithInternationalCode() {
        LanguageEntity languageEntity = new LanguageEntity(1, "en");

        when(languageRepository.findLanguageEntityByInternationCode("en")).thenReturn(languageEntity);

        Language language = new Language(1, "en");

        assertThat(languageDAO.getLanguageWithInternationalCode("en")).isEqualTo(language);
    }
}