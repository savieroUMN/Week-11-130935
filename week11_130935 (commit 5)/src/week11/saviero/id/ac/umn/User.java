package week11.saviero.id.ac.umn;

public class User {
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String username;
    private String password;

    public User(String firstName, String lastName, String gender, String address,
                String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public boolean login(String user, String pass) throws AuthenticationException {
        if (this.username.equals(user) && this.password.equals(pass)) {
            return true;
        }
        throw new AuthenticationException("Username / password salah");
    }

    public String getNamaLengkap() {
        return firstName + " " + lastName;
    }
}

