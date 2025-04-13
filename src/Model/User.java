package Model;

public class User {
    private String name;
    private String username;
    private String password;
    private PostalAddress postalAddress;

    public User(String name, String username, String password, PostalAddress postalAddress){
        this.name = name;
        this.username = username;
        this.password = password;
        this.postalAddress = postalAddress;
    }

    public String getName() {
        return name;
    }

    public String getPassword(){
        return password;
    }
}
