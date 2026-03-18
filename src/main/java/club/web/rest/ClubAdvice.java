package club.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice(basePackages = "club.web.rest")
@RequiredArgsConstructor
@Slf4j
public class ClubAdvice {
    private final TeamValidator teamValidator;
    private final PlayerValidator playerValidator;

    @InitBinder("team")
    void initBinderForTeam(WebDataBinder binder) {binder.addValidators(teamValidator);}

    @InitBinder("playerDTO")
    void initBinderForPlayer(WebDataBinder binder) {binder.addValidators(playerValidator);}

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("illegal argument provided", ex);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(ex.getMessage());
    }
}
