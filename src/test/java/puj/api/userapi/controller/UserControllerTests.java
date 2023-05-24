package puj.api.userapi.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import puj.api.userapi.entity.User;
import puj.api.userapi.service.UserService;

public class UserControllerTests {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPaginas() {
        // Mocking data
        Page<User> mockedPage = mock(Page.class);
        when(mockedPage.getContent()).thenReturn(Arrays.asList(new User(), new User()));

        when(userService.paginas(any())).thenReturn(mockedPage);

        // Test
        ResponseEntity<Page<User>> response = userController.paginas(0, 10, "id", true);

        // Assertions
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(2, response.getBody().getContent().size());

        // Verify mocks
        verify(userService, times(1)).paginas(any());
    }

    @Test
    public void testListUsers() {
        // Mocking data
        List<User> mockedUsers = Arrays.asList(new User(), new User());
        when(userService.listUsers()).thenReturn(mockedUsers);

        // Test
        List<User> result = userController.listUsers();

        // Assertions
        Assertions.assertEquals(2, result.size());

        // Verify mocks
        verify(userService, times(1)).listUsers();
    }

    @Test
    public void testFindToolByName() {
        // Mocking data
        String name = "John";
        List<User> mockedUsers = Arrays.asList(new User(), new User());
        when(userService.findByName(name)).thenReturn(mockedUsers);

        // Test
        List<User> result = userController.findToolByName(name);

        // Assertions
        Assertions.assertEquals(2, result.size());

        // Verify mocks
        verify(userService, times(1)).findByName(name);
    }

    @Test
    public void testFindUserById() {
        // Mocking data
        Integer id = 1;
        User mockedUser = new User();
        when(userService.findById(id)).thenReturn(mockedUser);

        // Test
        User result = userController.findUserById(id);

        // Assertions
        Assertions.assertNotNull(result);

        // Verify mocks
        verify(userService, times(1)).findById(id);
    }

    @Test
    public void testCreateUser() {
        // Mocking data
        User user = new User();
        when(userService.createUser(user)).thenReturn(user);

        // Test
        User result = userController.createUser(user);

        // Assertions
        Assertions.assertNotNull(result);

        // Verify mocks
        verify(userService, times(1)).createUser(user);
    }

    @Test
    public void testDelete() {
        // Mocking data
        Integer id = 1;
        when(userService.delete(id)).thenReturn(true);

        // Test
        HttpStatus result = userController.delete(id);

        // Assertions
        Assertions.assertEquals(HttpStatus.ACCEPTED, result);

        // Verify mocks
        verify(userService, times(1)).delete(id);
    }
}
