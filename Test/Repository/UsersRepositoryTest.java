package Repository;

import Model.PostalAddress;
import Model.User;
import org.junit.jupiter.api.*;
import Exception.DuplicatedUsernameException;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryTest {

    private UsersRepository usersRepository;


    @BeforeEach
    void setUp() {
        usersRepository = new UsersRepository();
        usersRepository.register("filipe", "filipe222", "1243", new PostalAddress("CG"));
    }

    @AfterEach
    void tearDown() {
        usersRepository = null;
    }

    @Test
    @DisplayName("Registering a user with correct information")
    void registerSuccess() {
        String name = "jao";
        String username = "filipe211";
        String password = "123";
        PostalAddress postalAddress = new PostalAddress("CG");

        User registeredUser = usersRepository.register(name, username, password, postalAddress);

        assertNotNull(registeredUser);
        assertEquals("jao", registeredUser.getName());
        assertEquals("jao", usersRepository.getName("filipe211"));
    }

    @Test
    @DisplayName("Registering a user with duplicated information")
    void registerFailedDuplicatedInfo(){
        String name = "jay";
        String username = "filipe222";
        String password = "13";
        PostalAddress postalAddress = new PostalAddress("JP");

        DuplicatedUsernameException exception = assertThrows(DuplicatedUsernameException.class, () ->
                usersRepository.register(name, username, password, postalAddress));

        assertEquals("User already exist", exception.getMessage());
    }

    @Test
    void deleteAccount() {
        String username = "filipe222";
        assertEquals(true, usersRepository.checkIfUserExists(username));
        usersRepository.deleteAccount(username, "1243");
        assertEquals(false, usersRepository.checkIfUserExists(username));
    }
}