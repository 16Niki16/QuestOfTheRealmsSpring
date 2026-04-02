package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import sofia.sap.interview.project.game.dto.loadgame.PlaygroundFactory;
import sofia.sap.interview.project.game.dto.data.PlaygroundData;
import sofia.sap.interview.project.game.exceptions.NewGameFileException;
import sofia.sap.interview.project.game.map.Playground;

import java.io.File;
import java.io.IOException;

public class NewGame {
    public static Playground createPlayground() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            PlaygroundData dto = mapper.readValue(new File("files\\maps\\CommonMap.json"), PlaygroundData.class);
            return PlaygroundFactory.create(dto);
        } catch (IOException e) {
            throw new NewGameFileException("Failed to load playground!", e);
        }
    }
}
