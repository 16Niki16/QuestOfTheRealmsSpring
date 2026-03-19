package sofia.sap.interview.project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sofia.sap.interview.project.game.GameService;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.CommandFactory;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.events.EventProcessor;
import sofia.sap.interview.project.game.files.SaveGame;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameRestController {
    private final GameService gameService;

    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> newGame(@RequestParam String username,
                                     @RequestParam String characterName,
                                     @RequestParam AllyCharacterType type) {
        User user = gameService.getOrCreateUser(username);
        user.createNewGame(characterName, type);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/command")
    public ResponseEntity<List<?>> executeCommand(@RequestParam String username,
                                                  @RequestBody String input) {
        User user = gameService.getUser(username);
        Command command = CommandFactory.createCommand(input);
        List<CommandResult> results = command.execute(user);
        List<CommandResult> processed = EventProcessor.process(user, results);
        return ResponseEntity.ok(GameEventMapper.result(processed));
    }

    @PostMapping("/load")
    public ResponseEntity<?> loadGame(@RequestParam String username) {
        User user = gameService.getOrCreateUser(username);
        user.loadGame();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveGame(@RequestParam String username) {
        User user = gameService.getUser(username);
        SaveGame.saveGame(user);
        return ResponseEntity.ok().build();
    }
}
