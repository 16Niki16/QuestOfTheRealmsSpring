package sofia.sap.interview.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sofia.sap.interview.project.game.exceptions.ChestNotAvailableException;
import sofia.sap.interview.project.game.exceptions.CommandNotAvailableException;
import sofia.sap.interview.project.game.exceptions.DirectionNotAvailableException;
import sofia.sap.interview.project.game.exceptions.EquipmentNotEquippedException;
import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.exceptions.ItemTypeAlreadyEquippedException;
import sofia.sap.interview.project.game.exceptions.LoadGameException;
import sofia.sap.interview.project.game.exceptions.NewGameFileException;
import sofia.sap.interview.project.game.exceptions.SaveGameException;

@RestControllerAdvice
public class GameExceptionHandler {
    @ExceptionHandler({
            ChestNotAvailableException.class,
            EquipmentNotEquippedException.class,
            ItemNotAvailableException.class,
            DirectionNotAvailableException.class
    })
    public ResponseEntity<String> handleNotFound(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({
            NewGameFileException.class,
            LoadGameException.class,
            SaveGameException.class
    })
    public ResponseEntity<String> handleFileErrors(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            CommandNotAvailableException.class})
    public ResponseEntity<String> handleInvalidInput(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ItemTypeAlreadyEquippedException.class)
    public ResponseEntity<String> handleAlreadyEquipped(ItemTypeAlreadyEquippedException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpected(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Unexpected error occurred");
    }
}