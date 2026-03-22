package sofia.sap.interview.project.game.files;

import sofia.sap.interview.project.game.exceptions.LoadGameException;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class SavedGamesList {
    public static List<String> getSaveFiles(User user) {
        Path dir = Path.of("files", user.getUsername());

        if (!Files.exists(dir)) {
            throw new LoadGameException("No saved games found!");
        }

        try (Stream<Path> files = Files.list(dir)) {
            return files
                .map(p -> p.getFileName().toString())
                .sorted()
                .toList();
        } catch (IOException e) {
            throw new LoadGameException("Could not extract the file names of the saved games!");
        }
    }
}
