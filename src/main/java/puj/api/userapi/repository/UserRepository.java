package puj.api.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import puj.api.userapi.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
    
}
