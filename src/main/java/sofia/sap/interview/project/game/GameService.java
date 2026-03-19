package sofia.sap.interview.project.game;

import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.systems.SystemsStarter;
import sofia.sap.interview.project.game.user.User;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final SystemsStarter starter;

    public GameService() {
        this.starter = new SystemsStarter(new HashSet<>(users.values()));
        starter.start();
    }

    public User getOrCreateUser(String username) {
        return users.computeIfAbsent(username, User::createUser);
    }

    public User getUser(String username) {
        User user = users.get(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found: " + username);
        }
        return user;
    }
}
