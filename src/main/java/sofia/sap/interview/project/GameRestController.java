package sofia.sap.interview.project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sofia.sap.interview.project.game.GameService;
import sofia.sap.interview.project.game.command.CommandFactory;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.events.EventProcessor;
import sofia.sap.interview.project.game.files.SaveGame;
import sofia.sap.interview.project.game.request.CommandRequest;
import sofia.sap.interview.project.game.request.NewGameRequest;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameRestController {
    private final GameService gameService;

    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/user/{username}")
    public ResponseEntity<?> userRegistration(@PathVariable String username) {
        gameService.getOrCreateUser(username);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/{username}/new")
    public ResponseEntity<?> newGame(@PathVariable String username, @RequestBody NewGameRequest request) {
        User user = gameService.getUser(username);
        user.createNewGame(request.characterName(), request.type());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/{username}/command")
    public ResponseEntity<List<?>> executeCommand(@PathVariable String username, @RequestBody CommandRequest request) {
        List<CommandResult> commandResults = GameRestControllerHelpers.commandResults(username, request, gameService);
        return ResponseEntity.ok(GameEventMapper.result(commandResults));
    }

    @PostMapping("/user/{username}/load")
    public ResponseEntity<?> loadGame(@PathVariable String username) {
        User user = gameService.getUser(username);
        user.loadGame();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/{username}/save")
    public ResponseEntity<?> saveGame(@PathVariable String username) {
        User user = gameService.getUser(username);
        SaveGame.saveGame(user);
        return ResponseEntity.ok().build();
    }
}
