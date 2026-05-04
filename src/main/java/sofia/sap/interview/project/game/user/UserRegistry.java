package sofia.sap.interview.project.game.user;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserRegistry {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public User connectUser(String username, User user) {
        return users.putIfAbsent(username, user);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }
}
