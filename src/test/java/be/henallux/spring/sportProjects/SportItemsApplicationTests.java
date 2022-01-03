package be.henallux.spring.sportProjects;

import be.henallux.spring.sportProjects.dataAccess.dao.UserDAO;
import be.henallux.spring.sportProjects.dataAccess.entity.UserEntity;
import be.henallux.spring.sportProjects.dataAccess.repository.UserRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class SportItemsApplicationTests {
	private UserDAO userDAO;

	@Mock private ProviderConverter providerConverter;
	@Mock private UserRepository userRepository;

	@Before
	public void setUp() {
		userDAO = new UserDAO(userRepository, providerConverter);
	}

	@Test
	void testUserDAOGetFromUsername() {
		String username = "nico";
		ArrayList<UserEntity> userEntities = new ArrayList<>();
		userEntities.add(new UserEntity(1, "nicolasbernard@gmail.com", "Nicoals", "Bernard", "0445789662", "Spontin", 5530, "Rue de la rue", "14", new Date(), "nico", "password", "ROLE_USER", true, true, true, true));
		userEntities.add(new UserEntity(2, "thibautberg@gmail.com", "Thibaut", "Berg", "0478785222", "Marche-e-f", 6900, "Rue de la station", "25", new Date(), "tibo", "password", "ROLE_USER", true, true, true, true));
	}


}
