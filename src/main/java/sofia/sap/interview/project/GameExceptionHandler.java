package sofia.sap.interview.project;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
import sofia.sap.interview.project.game.exceptions.SessionInProgressException;
import sofia.sap.interview.project.game.exceptions.UnknownResultTypeException;
import sofia.sap.interview.project.game.exceptions.UserNotFoundException;
import sofia.sap.interview.project.game.exceptions.UsernameAlreadyExistException;

@RestControllerAdvice
public class GameExceptionHandler {
    @ExceptionHandler({
        SessionInProgressException.class,
        UsernameAlreadyExistException.class,
        IllegalArgumentException.class,
        CommandNotAvailableException.class,
        NoActiveSessionException.class,
    })
    public ResponseEntity<String> handleInvalidInput(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleInvalidJson(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Invalid request format!");
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidation(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .findFirst()
            .orElse("Invalid request");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(errorMessage);
    }

    @ExceptionHandler({
        UserNotFoundException.class,
        ChestNotAvailableException.class,
        EquipmentNotEquippedException.class,
        ItemNotAvailableException.class,
        DirectionNotAvailableException.class,
        NoEnemyInTheRoomException.class,
        EnemyTypeNotAvailableException.class,
        QuestTypeNotFoundException.class,
        UnknownResultTypeException.class
    })
    public ResponseEntity<String> handleNotFound(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(ItemTypeAlreadyEquippedException.class)
    public ResponseEntity<String> handleAlreadyEquipped(ItemTypeAlreadyEquippedException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler({
        NewGameFileException.class,
        LoadGameException.class,
        SaveGameException.class,
        EndGameFileException.class
    })
    public ResponseEntity<String> handleFileErrors(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpected(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Unexpected error occurred");
    }
}