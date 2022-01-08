package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.dataAccess.entity.UserEntity;
import be.henallux.spring.sportProjects.dataAccess.repository.UserRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDAO implements UserDataAccess{
    private UserRepository userRepository;
    private ProviderConverter converter;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    @Override
    public User findByUsername(String username) {
        return converter.userEntityToUserModel(userRepository.findUserByUsername(username));
    }

    @Override
    public boolean isEmailAlreadyUsed(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean isUsernameAlreadyUsed(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void postUser(User user) {
        UserEntity userEntity = converter.userModelToUserEntity(user);
        userRepository.save(userEntity);
    }
}
