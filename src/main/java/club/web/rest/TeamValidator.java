package club.web.rest;

import club.model.Team;
import club.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class TeamValidator implements Validator {

    private final TeamService teamService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Team.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Team validatedTeam = (Team) target;

        boolean duplicated = teamService.getAllTeams().stream()
            .anyMatch(team -> team.getName().equalsIgnoreCase(validatedTeam.getName()));

        if (duplicated) {
            errors.rejectValue("name", "team.name.duplicated");
        }
    }
}