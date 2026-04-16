package sofia.sap.interview.project;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sofia.sap.interview.project.game.GameService;
import sofia.sap.interview.project.game.exceptions.NoActiveSessionException;
import sofia.sap.interview.project.game.request.CommandRequest;
import sofia.sap.interview.project.game.request.CreateUserRequest;
import sofia.sap.interview.project.game.request.NewGameRequest;
import sofia.sap.interview.project.game.request.ResumeGameRequest;
import sofia.sap.interview.project.game.results.CommandResult;
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
    public ResponseEntity<?> userRegistration(@Valid @RequestBody CreateUserRequest createUserRequest) {
        gameService.registerUser(createUserRequest.username());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/{username}/new")
    public ResponseEntity<?> newGame(@PathVariable String username,
                                     @Valid @RequestBody NewGameRequest request) {
        User user = gameService.getUser(username);

        return ResponseEntity.ok(gameService.createNewGame(user, request));
    }

    @PostMapping("/user/{username}/command")
    public ResponseEntity<List<?>> executeCommand(@PathVariable String username,
                                                  @Valid @RequestBody CommandRequest request) {
        User user = gameService.getUser(username);

        if (!user.isActiveSession()) {
            throw new NoActiveSessionException("Create a game before execute a command!");
        }

        List<CommandResult> commandResults = gameService.commandExecute(user, request);

        return ResponseEntity.ok(commandResults);
    }

    @GetMapping("/user/{username}/saves")
    public ResponseEntity<?> savesGame(@PathVariable String username) {
        User user = gameService.getUser(username);

        return ResponseEntity.ok(gameService.loadSavedGames(user));
    }

    @PostMapping("/user/{username}/resume")
    public ResponseEntity<?> resumeGame(@PathVariable String username,
                                        @Valid @RequestBody ResumeGameRequest request) {
        User user = gameService.getUser(username);

        return ResponseEntity.ok(gameService.resumeSavedGame(user, request));
    }
}
