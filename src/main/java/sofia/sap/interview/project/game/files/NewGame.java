package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import sofia.sap.interview.project.game.dto.data.PlaygroundData;
import sofia.sap.interview.project.game.dto.loadgame.PlaygroundFactory;
import sofia.sap.interview.project.game.exceptions.NewGameFileException;
import sofia.sap.interview.project.game.map.Playground;

import java.io.IOException;
import java.nio.file.Path;

public class NewGame {
    public static Playground createPlayground() {
        ObjectMapper mapper = new ObjectMapper();
        Path mapPath = Path.of("files", "maps", "CommonMap.json");

        try {
            PlaygroundData dto = mapper.readValue(mapPath.toFile(), PlaygroundData.class);
            return PlaygroundFactory.create(dto);
        } catch (IOException e) {
            throw new NewGameFileException("Failed to load playground!", e);
        }
    }
}
