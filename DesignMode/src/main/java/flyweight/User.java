package flyweight;

/**
 *  不同对象间的不同实例
 *
 * @author Jion
 */
public class User {

    private final String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
