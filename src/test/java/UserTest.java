import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {


    private User user;

    @BeforeEach
    void setUp() {
        user = new User("user", "password", "user@email.com");
    }

    @Test
    public void test_getLogin() {
        assertEquals("user", user.getLogin());
        assertNotEquals("another user", user.getLogin());
        assertNotNull(user.getLogin());
    }

    @Test
    public void test_getLogin_null() {
        User user = new User(null, "password", "user@email.com");
        assertNull(user.getLogin());
    }

    @Test
    public void getPassword_success() {
        assertEquals("password", user.getPassword());
        assertNotEquals("false password", user.getPassword());
        assertNotNull(user.getPassword());
    }

    @Test
    public void getPassword_null() {
        User user = new User("user", null, "user@email.com");
        assertNull(user.getPassword());
    }

    @Test
    public void getEmail_success() {
        assertEquals("user@email.com", user.getEmail());
        assertNotEquals("user@Email.com", user.getEmail());
        assertNotNull(user.getEmail());
    }

    @Test
    public void getEmail_null() {
        User user = new User("user", "password", null);
        assertNull(user.getEmail());
    }

    @Test
    public void setLogin_success() {
        user.setLogin("newUser");
        assertEquals("newUser", user.getLogin());
        assertNotNull(user.getLogin());
        System.out.println(user);

    }

    @Test
    public void setLogin_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> user.setLogin("ab"));
    }

    @Test
    public void setPassword_success() {
        user.setPassword("newPassword");
        assertEquals("newPassword", user.getPassword());
        assertNotNull(user.getPassword());
        System.out.println(user);
    }

    @Test
    public void setPassword_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> user.setPassword("abcd"));
    }

    @Test
    public void setEmail_success() {
        user.setEmail("user@newemail.com");
        assertEquals("user@newemail.com", user.getEmail());
        assertNotNull(user.getEmail());
        System.out.println(user);
    }

    @Test
    public void setEmail_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> user.setEmail("userNewEmail.com"));
    }

    @Test
    public void isValidPassword_success() {
        assertTrue(user.isValidPassword("password"));
        assertFalse(user.isValidPassword("false password"));
    }
}