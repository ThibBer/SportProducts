package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.UserDAO;
import be.henallux.spring.sportProjects.dataAccess.dao.UserDataAccess;
import be.henallux.spring.sportProjects.dataAccess.entity.UserEntity;
import be.henallux.spring.sportProjects.dataAccess.repository.UserRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserDetailsServiceImplementationTest {
    private UserDataAccess userDAO;
    private ProviderConverter providerConverter;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        providerConverter = new ProviderConverter();
        userDAO = new UserDAO(userRepository, providerConverter);
    }

    @Test
    public void loadUserByUsername() {
        UserEntity nicolasEntity = new UserEntity(1, "nicolasbernard@gmail.com", "Nicoals", "Bernard", "0445789662", "Spontin", 5530, "Rue de la rue", "14", new Date(), "nico", "password", "ROLE_USER", true, true, true, true);
        when(userRepository.findUserByUsername("nico")).thenReturn(nicolasEntity);

        User nicolas = new User(1, "nicolasbernard@gmail.com", "Nicoals", "Bernard", "0445789662", "Spontin", 5530, "Rue de la rue", "14", new Date(), "nico", "password", "ROLE_USER", true, true, true, true);
        assertThat(userDAO.findByUsername("nico")).isEqualTo(nicolas);
    }
}