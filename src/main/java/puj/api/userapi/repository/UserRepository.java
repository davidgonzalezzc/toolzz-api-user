package puj.api.userapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import puj.api.userapi.entity.User;

/**
 * Clase interfaz jpa para la interacción del servicio con la base de datos
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    List<User> findByName(String name);
    Optional<User> findById(Integer id);
}
