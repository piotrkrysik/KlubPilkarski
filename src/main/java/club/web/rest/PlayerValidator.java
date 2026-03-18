package club.web.rest;

import club.model.Coach;
import club.model.Player;
import club.service.PlayerService;
import club.web.rest.dto.PlayerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class PlayerValidator implements Validator {
    private final PlayerService playerService;

    @Override
    public boolean supports(Class<?> clazz) {return clazz.isAssignableFrom(PlayerDTO.class);}

    @Override
    public void validate(Object target, Errors errors) {
        PlayerDTO playerDTO = (PlayerDTO) target;
        Coach coach = playerService.getCoachById(playerDTO.getCoachId());
        if (coach == null) {
            errors.rejectValue("coachId", "coach.not.found");
        }
    }
}
