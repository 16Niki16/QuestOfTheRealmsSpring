package sofia.sap.interview.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sofia.sap.interview.project.game.exceptions.ChestNotAvailableException;
import sofia.sap.interview.project.game.exceptions.CommandNotAvailableException;
import sofia.sap.interview.project.game.exceptions.DirectionNotAvailableException;
import sofia.sap.interview.project.game.exceptions.EndGameFileException;
import sofia.sap.interview.project.game.exceptions.EnemyTypeNotAvailableException;
import sofia.sap.interview.project.game.exceptions.EquipmentNotEquippedException;
import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.exceptions.ItemTypeAlreadyEquippedException;
import sofia.sap.interview.project.game.exceptions.LoadGameException;
import sofia.sap.interview.project.game.exceptions.NewGameFileException;
import sofia.sap.interview.project.game.exceptions.NoActiveSessionException;
import sofia.sap.interview.project.game.exceptions.NoEnemyInTheRoomException;
import sofia.sap.interview.project.game.exceptions.QuestTypeNotFoundException;
import sofia.sap.interview.project.game.exceptions.SaveGameException;
import sofia.sap.interview.project.game.exceptions.UnknownResultTypeException;
import sofia.sap.interview.project.game.exceptions.UserNotFoundException;

@RestControllerAdvice
public class GameExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleInvalidJson(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request format!");
    }

    @ExceptionHandler({
        IllegalArgumentException.class,
        CommandNotAvailableException.class,
        NoActiveSessionException.class})
    public ResponseEntity<String> handleInvalidInput(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler({
        ChestNotAvailableException.class,
        EquipmentNotEquippedException.class,
        ItemNotAvailableException.class,
        DirectionNotAvailableException.class,
        UserNotFoundException.class,
        NoEnemyInTheRoomException.class,
        EnemyTypeNotAvailableException.class,
        QuestTypeNotFoundException.class,
        UnknownResultTypeException.class
    })
    public ResponseEntity<String> handleNotFound(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ItemTypeAlreadyEquippedException.class)
    public ResponseEntity<String> handleAlreadyEquipped(ItemTypeAlreadyEquippedException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler({
        NewGameFileException.class,
        LoadGameException.class,
        SaveGameException.class,
        EndGameFileException.class
    })
    public ResponseEntity<String> handleFileErrors(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpected(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Unexpected error occurred");
    }
}