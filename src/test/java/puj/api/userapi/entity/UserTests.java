package puj.api.userapi.entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTests {

    @Test
    public void testGettersAndSetters() {
        // Create a User instance
        User user = new User();

        // Set values using setters
        user.setId(1);
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setRole("user");
        user.setName("John");
        user.setLast("Doe");
        user.setBirthday("1990-01-01");

        // Use getters to retrieve values
        Assertions.assertEquals(1, user.getId());
        Assertions.assertEquals("test@example.com", user.getEmail());
        Assertions.assertEquals("password", user.getPassword());
        Assertions.assertEquals("user", user.getRole());
        Assertions.assertEquals("John", user.getName());
        Assertions.assertEquals("Doe", user.getLast());
        Assertions.assertEquals("1990-01-01", user.getBirthday());
    }

    @Test
    public void testEquals() {
        // Create two User instances with the same values
        User user1 = new User();
        user1.setId(1);
        user1.setEmail("test@example.com");

        User user2 = new User();
        user2.setId(1);
        user2.setEmail("test@example.com");

        // User instances should be equal
        Assertions.assertEquals(user1, user2);
    }

    @Test
    public void testHashCode() {
        // Create a User instance
        User user = new User();
        user.setId(1);
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setRole("user");
        user.setName("John");
        user.setLast("Doe");
        user.setBirthday("1990-01-01");

        // Calculate the hash code
        int hashCode = user.hashCode();

        // Assert that the hash code is not zero
        Assertions.assertNotEquals(0, hashCode);
    }

    @Test
    public void testNotEquals() {
        // Create two User instances with different values
        User user1 = new User();
        user1.setId(1);
        user1.setEmail("test1@example.com");

        User user2 = new User();
        user2.setId(2);
        user2.setEmail("test2@example.com");

        // User instances should not be equal
        Assertions.assertNotEquals(user1, user2);
    }
}
