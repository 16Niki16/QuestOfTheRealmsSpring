package sofia.sap.interview.project.game.files;

import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.user.User;

import java.nio.file.Path;

@Component
public class PathResolver {
    private static final String BASE = "files";
    private static final String MAPS_FOLDER = "maps";
    private static final String EXT = ".json";

    public Path userFile(User user, String filename) {
        String fullFileName = ensureExtension(filename);
        return Path.of(BASE, user.getUsername(), fullFileName);
    }

    public Path userDir(User user) {
        return Path.of(BASE, user.getUsername());
    }

    public Path mapFile(String mapName) {
        String fullFileName = ensureExtension(mapName);
        return Path.of(BASE, MAPS_FOLDER, fullFileName);
    }

    private String ensureExtension(String filename) {
        return filename.endsWith(EXT) ? filename : filename + EXT;
    }
}
