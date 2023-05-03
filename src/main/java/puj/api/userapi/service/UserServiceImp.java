package puj.api.userapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.api.userapi.entity.User;
import puj.api.userapi.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    /** 
     * Metodo para haciendo uso de toolRepository listar las herramientas
     * @return lista de herramientas
     */
    @Override
    public List<User> listUsers() {
        List<User> users = new ArrayList<User>();
        users.addAll(userRepository.findAll());
        return users;
    }

    
    
    /** 
     * Metodo que encuentra una lista de usuarios usando toolRepository
     * @param name Parametro que trae el nombre del usuario a buscar
     * @return Retorna una lista de usuarios
     */
    @Override
    public List<User> findByName(String name) {
        List<User> tools = new ArrayList<User>();
        tools = userRepository.findByName(name);
        return tools;
    }

    
    /** 
     * Metodo que encuentra una herramienta a partir del id 
     * @param id id por parametro que representa la herramienta a buscar
     * @return Retorna un objeto de tipo Tool
     */
    @Override
    public User findById(Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    
    /** 
     * Metodo para crear un usuario a traves del repositorio jpa userRepository
     * @param user
     * @return Retorna un objeto de tipo usuario ya mapeado
     */
    @Override
    public User createUser(User user) {
        User newuser = new User();
        newuser.setName(user.getName());
        newuser.setLast(user.getLast());
        newuser.setEmail(user.getEmail());
        newuser.setRole(user.getRole());
        newuser.setPassword(user.getPassword());
        newuser.setBirthday(user.getBirthday());
        userRepository.save(newuser);
        return newuser;
    }


    
    /** 
     * Metodo que elimina un usuario segun el id que se le pase por parametro
     * @param id id del usuario
     * @return True si se elimino, falso si no
     */
    @Override
    public Boolean delete(Integer id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return true;
    }


    
    /** 
     * Metodo para modificar un usuario, ya viene el usuario
     * @param user Usuario a modificar
     * @return Retorna el usuario ya modificado
     */
    @Override
    public User modifyUser(User user) {
        User newuser = new User();
        user.setName(user.getName());
        user.setLast(user.getLast());
        user.setEmail(user.getEmail());
        user.setRole(user.getRole());
        user.setPassword(user.getPassword());
        userRepository.save(newuser);
        return newuser;
    }



    
}
