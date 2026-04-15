package sofia.sap.interview.project.game.files;

import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.user.User;

import java.nio.file.Path;

@Component
public class PathResolver {
    private static final String BASE = "file";
    private static final String MAPS_FOLDER = "maps";

    public Path userFile(User user, String filename) {
        return Path.of(BASE, user.getUsername(), filename);
    }

    public Path userDir(User user) {
        return Path.of(BASE, user.getUsername());
    }

    public Path mapFile(String mapName) {
        return Path.of(BASE, MAPS_FOLDER, mapName);
    }
}
