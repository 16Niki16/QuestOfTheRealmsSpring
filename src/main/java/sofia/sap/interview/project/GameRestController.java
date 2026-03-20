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
import sofia.sap.interview.project.game.request.CommandRequest;
import sofia.sap.interview.project.game.request.LoadGameRequest;
import sofia.sap.interview.project.game.request.NewGameRequest;
import sofia.sap.interview.project.game.request.RegisterRequest;
import sofia.sap.interview.project.game.request.SaveGameRequest;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameRestController {
    private final GameService gameService;

    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> userRegistration(@RequestBody RegisterRequest request) {
        gameService.getOrCreateUser(request.username());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/new")
    public ResponseEntity<?> newGame(@RequestBody NewGameRequest request) {
        User user = gameService.getUser(request.username());
        user.createNewGame(request.characterName(), request.type());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/command")
    public ResponseEntity<List<?>> executeCommand(@RequestBody CommandRequest request) {
        User user = gameService.getUser(request.username());
        Command command = CommandFactory.createCommand(request.command());
        List<CommandResult> results = command.execute(user);
        List<CommandResult> processed = EventProcessor.process(user, results);
        return ResponseEntity.ok(GameEventMapper.result(processed));
    }

    @PostMapping("/load")
    public ResponseEntity<?> loadGame(@RequestBody LoadGameRequest request) {
        User user = gameService.getUser(request.username());
        user.loadGame();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveGame(@RequestBody SaveGameRequest request) {
        User user = gameService.getUser(request.username());
        SaveGame.saveGame(user);
        return ResponseEntity.ok().build();
    }
}
