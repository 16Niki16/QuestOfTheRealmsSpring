package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.dto.data.PlaygroundData;
import sofia.sap.interview.project.game.exceptions.NewGameFileException;
import sofia.sap.interview.project.game.map.Playground;

import java.io.IOException;
import java.nio.file.Path;

import static sofia.sap.interview.project.game.dto.loadgame.PlaygroundFactory.create;

@Service
@RequiredArgsConstructor
public class MapService {
    private final ObjectMapper mapper;
    private final PathResolver pathResolver;
    private PlaygroundData mapData;

    public synchronized Playground createPlayground() {
        if (mapData == null) {
            Path mapPath = pathResolver.mapFile("CommonMap");

            try {
                mapData = mapper.readValue(mapPath.toFile(), PlaygroundData.class);
            } catch (IOException e) {
                throw new NewGameFileException("Failed to load playground!", e);
            }
        }
        return create(mapData);
    }
}
