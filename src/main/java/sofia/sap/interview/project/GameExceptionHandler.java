package sofia.sap.interview.project;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sofia.sap.interview.project.game.exceptions.ChestNotAvailableException;
import sofia.sap.interview.project.game.exceptions.CommandArgumentException;
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
import sofia.sap.interview.project.game.results.ErrorResponseDTO;

import java.util.List;

@RestControllerAdvice
public class GameExceptionHandler {
    @ExceptionHandler({
        SessionInProgressException.class,
        UsernameAlreadyExistException.class,
        IllegalArgumentException.class,
        CommandNotAvailableException.class,
        NoActiveSessionException.class,
        CommandArgumentException.class
    })
    public ResponseEntity<ErrorResponseDTO> handleInvalidInput(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ErrorResponseDTO(List.of(e.getMessage())));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidJson(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ErrorResponseDTO(List.of("Invalid request format!")));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidation(MethodArgumentNotValidException e) {
        List<String> errorMessages = e.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ErrorResponseDTO(errorMessages));
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
    public ResponseEntity<ErrorResponseDTO> handleNotFound(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ErrorResponseDTO(List.of(e.getMessage())));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponseDTO> handleMethodNotSupported(HttpRequestMethodNotSupportedException e) {

        String message = String.format(
                "Method %s is not supported for this endpoint. Supported methods: %s",
                e.getMethod(), e.getSupportedHttpMethods());

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(new ErrorResponseDTO(List.of(message)));
    }

    @ExceptionHandler(ItemTypeAlreadyEquippedException.class)
    public ResponseEntity<ErrorResponseDTO> handleAlreadyEquipped(ItemTypeAlreadyEquippedException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(new ErrorResponseDTO(List.of(e.getMessage())));
    }

    @ExceptionHandler({
        NewGameFileException.class,
        LoadGameException.class,
        SaveGameException.class,
        EndGameFileException.class
    })
    public ResponseEntity<ErrorResponseDTO> handleFileErrors(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ErrorResponseDTO(List.of(e.getMessage())));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleUnexpected(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ErrorResponseDTO(List.of("Unexpected error occurred")));
    }
}