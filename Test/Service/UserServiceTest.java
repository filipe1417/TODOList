package Service;

import Model.PostalAddress;
import Model.User;
import Repository.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @AfterEach
    void tearDown() {
        userService = null;
    }

    @Test
    @DisplayName("Registering a user with correct information")
    void registerUser() {
        String name = "jaoaa";
        String username = "filipe211";
        String password = "12344";
        PostalAddress postalAddress = new PostalAddress("CG");

        User registeredUser = userService.registerUser(name, username, password, postalAddress);

        assertNotNull(registeredUser);
        assertEquals("jaoaa", registeredUser.getName());
    }
}