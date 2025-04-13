package Repository;

import Model.PostalAddress;
import Model.User;
import Exception.DuplicatedUsernameException;

import java.util.HashMap;

public class UsersRepository {
    private HashMap<String, User> userMap;

    public UsersRepository() {
        this.userMap = new HashMap<>();
    }

    public User register(String name, String username, String password, PostalAddress postalAddress) throws DuplicatedUsernameException{
        if (userMap.containsKey(username)) {
            throw new DuplicatedUsernameException();
        }

        User newUser = new User(name, username, password, postalAddress);
        userMap.put(username, newUser);
        return newUser;
    }

    public Boolean deleteAccount(String username, String password){
        if (!userMap.get(username).getPassword().equals(password)){
            return false;
        }
        userMap.remove(username);
        return true;
    }

    public Boolean checkIfUserExists(String username){
        return userMap.containsKey(username);
    }

    public String getName(String username){
        return userMap.get(username).getName();
    }

}
