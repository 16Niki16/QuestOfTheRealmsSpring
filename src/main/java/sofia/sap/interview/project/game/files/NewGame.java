package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import sofia.sap.interview.project.game.dto.newgame.PlaygroundDTO;
import sofia.sap.interview.project.game.dto.newgame.mappers.PlaygroundMapper;
import sofia.sap.interview.project.game.exceptions.NewGameFileException;
import sofia.sap.interview.project.game.map.Playground;

import java.io.File;
import java.io.IOException;

public class NewGame {
    public static Playground createPlayground() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            PlaygroundDTO dto = mapper.readValue(new File("files\\CommonMap.json"), PlaygroundDTO.class);
            return PlaygroundMapper.map(dto);
        } catch (IOException e) {
            throw new NewGameFileException("Failed to load playground", e);
        }
    }
}
