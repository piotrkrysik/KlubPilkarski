package Club.service;

import Club.model.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ClubServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find football teams!");

        // Inicjalizacja kontekstu
        ApplicationContext context = new AnnotationConfigApplicationContext("Club");

        // TEST SCOPE: Pobranie dwóch instancji serwisu
        // Jeśli w PlayerServiceBean dodasz @Scope("prototype"), te dwa obiekty będą miały różne ID
        TeamService service = context.getBean(TeamService.class);
        TeamService service2 = context.getBean(TeamService.class);

        // TEST CONFIG: Pobranie ręcznie zdefiniowanego beana String
        String myText = context.getBean(String.class);
        System.out.println("Pobrany bean z ClubConfig: " + myText);

        // Standardowe użycie API
        List<Team> teams = service.getAllTeams();
        System.out.println(teams.size() + " teams found:");
        teams.forEach(System.out::println);
    }
}