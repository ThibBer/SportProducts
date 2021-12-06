package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.UserDAO;
import be.henallux.spring.sportProjects.dataAccess.dao.UserDataAccess;
import be.henallux.spring.sportProjects.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UserDataAccess userDAO;

    @Autowired
    public UserDetailsServiceImplementation(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.getUserFromUsername(username);
        System.out.println(user);

        if(user == null){
            System.out.println("Invalid username");
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println(user);

        return user;
    }
}
