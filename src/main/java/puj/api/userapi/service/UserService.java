package puj.api.userapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import puj.api.userapi.entity.User;

/**
 * Interfaz para definir los metodos del servicio de usuarios
 */
public interface UserService {
    public List<User> listUsers();
    public User findById(Integer id);
    public List<User> findByName(String name);
    public User createUser(User user);
    public Boolean delete(Integer id);
    public User modifyUser(User user);
    public Page<User> paginas(Pageable pageable);
}
