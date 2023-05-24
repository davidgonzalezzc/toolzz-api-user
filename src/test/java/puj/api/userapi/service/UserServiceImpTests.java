package puj.api.userapi.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import puj.api.userapi.entity.User;
import puj.api.userapi.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class UserServiceImpTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListUsers() {
        // Create mock data
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        when(userRepository.findAll()).thenReturn(userList);

        // Call the service method
        List<User> result = userService.listUsers();

        // Assertions
        Assertions.assertEquals(userList, result);

        // Verify mock interactions
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testFindByName() {
        // Create mock data
        String name = "John";
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        when(userRepository.findByName(name)).thenReturn(userList);

        // Call the service method
        List<User> result = userService.findByName(name);

        // Assertions
        Assertions.assertEquals(userList, result);

        // Verify mock interactions
        verify(userRepository, times(1)).findByName(name);
    }

    @Test
    public void testFindById() {
        // Create mock data
        Integer id = 1;
        User user = new User();
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        // Call the service method
        User result = userService.findById(id);

        // Assertions
        Assertions.assertEquals(user, result);

        // Verify mock interactions
        verify(userRepository, times(1)).findById(id);
    }

    @Test
    public void testCreateUser() {
        // Create mock data
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        // Call the service method
        User result = userService.createUser(user);

        // Assertions
        Assertions.assertEquals(user, result);

        // Verify mock interactions
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testDelete() {
        // Create mock data
        Integer id = 1;
        User user = new User();
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        // Call the service method
        Boolean result = userService.delete(id);

        // Assertions
        Assertions.assertTrue(result);

        // Verify mock interactions
        verify(userRepository, times(1)).findById(id);
        verify(userRepository, times(1)).delete(user);
    }

    @Test
    public void testModifyUser() {
        // Create mock data
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        // Call the service method
        User result = userService.modifyUser(user);

        // Assertions
        Assertions.assertEquals(user, result);

        // Verify mock interactions
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testPaginas() {
        // Create mock data
        Pageable pageable = mock(Pageable.class);
        List<User> userList = new ArrayList<>();
        Page<User> page = new PageImpl<>(userList);
        when(userRepository.findAll(pageable)).thenReturn(page);

        // Call the service method
        Page<User> result = userService.paginas(pageable);

        // Assertions
        Assertions.assertEquals(page, result);

        // Verify mock interactions
        verify(userRepository, times(1)).findAll(pageable);
    }
}
