package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.model.User;

public interface UserDataAccess {
    User getUserFromUsername(String username);
    boolean isEmailAlreadyUsed(String email);
    Boolean isUsernameAlreadyUsed(String username);
    void postUser(User user);
}
