package Service;

import Model.PostalAddress;
import Model.User;
import Exception.DuplicatedUsernameException;
import Exception.MinimumLengthException;
import Repository.UsersRepository;

public class UserService {

    private UsersRepository usersRepository;

    public UserService(){
        usersRepository = new UsersRepository();
    }

    public User registerUser(String name, String username, String password, PostalAddress postalAddress) throws DuplicatedUsernameException {
        int usernameMinimumLength = 4;
        int passwordMinimumLength = 5;

        if (username.length() < usernameMinimumLength){
            throw new MinimumLengthException("Username should have more than " + usernameMinimumLength + " characters");
        } else if (password.length() < passwordMinimumLength) {
            throw new MinimumLengthException("Password should have more than " + passwordMinimumLength + " characters");
        }

        return usersRepository.register(name, username, password, postalAddress);
    }
}
