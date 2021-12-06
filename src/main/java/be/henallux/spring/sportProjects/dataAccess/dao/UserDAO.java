package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.dataAccess.repository.UserRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDAO implements UserDataAccess{
    private UserRepository userRepository;
    private ProviderConverter converter;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    @Override
    public User getUserFromUsername(String username) {
        return converter.userEntityToUserModel(userRepository.findUserByUsername(username));
    }
}
