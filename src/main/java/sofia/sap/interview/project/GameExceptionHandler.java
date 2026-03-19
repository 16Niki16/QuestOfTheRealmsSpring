package sofia.sap.interview.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sofia.sap.interview.project.game.exceptions.ChestNotAvailableException;
import sofia.sap.interview.project.game.exceptions.CommandNotAvailableException;
import sofia.sap.interview.project.game.exceptions.ItemTypeAlreadyEquippedException;
import sofia.sap.interview.project.game.exceptions.LoadGameException;
import sofia.sap.interview.project.game.exceptions.NewGameFileException;
import sofia.sap.interview.project.game.exceptions.SaveGameException;

@RestControllerAdvice
public class GameExceptionHandler {

    // 400 - грешка от потребителя
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    // 404 - нещо не е намерено
    @ExceptionHandler(ChestNotAvailableException.class)
    public ResponseEntity<String> handleChestNotAvailable(ChestNotAvailableException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(CommandNotAvailableException.class)
    public ResponseEntity<String> handleCommandNotAvailable(CommandNotAvailableException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    // 409 - конфликт (вече екипиран)
    @ExceptionHandler(ItemTypeAlreadyEquippedException.class)
    public ResponseEntity<String> handleAlreadyEquipped(ItemTypeAlreadyEquippedException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    // 500 - сървърна грешка
    @ExceptionHandler(NewGameFileException.class)
    public ResponseEntity<String> handleNewGameFile(NewGameFileException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    @ExceptionHandler(LoadGameException.class)
    public ResponseEntity<String> handleLoadGameFile(LoadGameException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    @ExceptionHandler(SaveGameException.class)
    public ResponseEntity<String> handleSaveGameFile(SaveGameException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpected(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Unexpected error occurred");
    }
}