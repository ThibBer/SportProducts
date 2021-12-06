package be.henallux.spring.sportProjects.dataAccess.repository;

import be.henallux.spring.sportProjects.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findUserByUsername(String username);
}
