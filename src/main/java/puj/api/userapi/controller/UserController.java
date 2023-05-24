package puj.api.userapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import puj.api.userapi.entity.User;
import puj.api.userapi.service.UserService;

/**
 * Clase controlador que recibe las peticiones que llegan a la API para 
 * mandarlas luego a los servicios
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    /**
     * @param page
     * @param size
     * @param order
     * @param asc
     * @return
     */
    @GetMapping("/searchPaginated")
    public ResponseEntity<Page<User>> paginas(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String order,
        @RequestParam(defaultValue = "true") boolean asc
        ){
            Page<User> users = userService.paginas(PageRequest.of(page,size,Sort.by(order)));
            if(!asc)
                users = userService.paginas(PageRequest.of(page,size,Sort.by(order).descending()));
            return new ResponseEntity<Page<User>>(users,HttpStatus.OK);
        }


    /** 
     * Metodo que trae la lista de usuarios del servicio
     * @return Retorna una lista de usuarios
     */
    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<User> listUsers(){
        return userService.listUsers();
    }

    /**
     * Metodo que encuentra un usuario segun su nombre
     * @param name nombre del usuario
     * @return retorna una lista de usuarios que tengan el nombre que viene por parametro
     */
    @GetMapping("/byname/{name}")
    public List<User> findToolByName(@PathVariable String name){
        return userService.findByName(name);
    }

    /**
     * Metodo para encontrar un usuario según su id
     * @param id parametro de id del usuario
     * @return Retorna un usuario segun el id proporcionado
     */
    @GetMapping("/byid/{id}")
    public User findUserById(@PathVariable Integer id){
        return userService.findById(id);
    }
    
    /**
     * Metodo para crear un usuario usando el metodo del servicio usuarioService
     * @param tool parametro de usuario a crear
     * @return Retorna el usuario creado
     */
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    
    /**
     * Metodo para eliminar un usuario según su id
     * @param id parametro id del usuario a eliminar
     * @return Retorna un codigo Http segun si es o no eliminado
     */
    @DeleteMapping("/user/{id}")
    public HttpStatus delete(@PathVariable  Integer id){
        return userService.delete(id)? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }

    /**
     * Metodo que modifica un usuario
     * @param tool parametro de usuario a modificar
     * @return usuario ya creado
     */
    @PostMapping("/user/modify")
    public User modifyUser(User user){
        return userService.modifyUser(user);
    }
    
}
