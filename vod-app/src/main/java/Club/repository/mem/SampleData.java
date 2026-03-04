package Club.repository.mem;

import Club.model.Team;
import Club.model.Coach;
import Club.model.Player;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    // Zmienione nazwy list na adekwatne do sportu
    static List<Team> teams = new ArrayList<>();
    static List<Coach> coaches = new ArrayList<>();
    static List<Player> players = new ArrayList<>();

    static {
        // Tworzymy Trenerów (zamiast reżyserów)
        Coach ancelotti = new Coach(1, "Carlo", "Ancelotti");
        Coach guardiola = new Coach(2, "Pep", "Guardiola");
        Coach klopp = new Coach(3, "Jurgen", "Klopp");
        Coach flick = new Coach(4, "Hansi", "Flick");

        // Tworzymy Zawodników (zamiast filmów)
        // Argumenty konstruktora: id, name, photoUrl, coach, marketValue
        Player vinicius = new Player(1, "Vinicius Jr", "https://url-do-zdjecia-vini.jpg", ancelotti, (float) 180.5);
        Player mbappe = new Player(2, "Kylian Mbappe", "https://url-do-zdjecia-mbappe.jpg", ancelotti, (float) 190.0);

        Player haaland = new Player(3, "Erling Haaland", "https://url-do-zdjecia-haaland.jpg", guardiola, (float) 200.0);
        Player rodri = new Player(4, "Rodri", "https://url-do-zdjecia-rodri.jpg", guardiola, (float) 130.0);

        Player salah = new Player(5, "Mohamed Salah", "https://url-do-zdjecia-salah.jpg", klopp, (float) 65.0);
        Player vanDijk = new Player(6, "Virgil van Dijk", "https://url-do-zdjecia-vandijk.jpg", klopp, (float) 30.0);

        Player lewandowski = new Player(7, "Robert Lewandowski", "https://url-do-zdjecia-lewy.jpg", flick, (float) 15.0);
        Player yamal = new Player(8, "Lamine Yamal", "https://url-do-zdjecia-yamal.jpg", flick, (float) 120.0);

        // Wiązanie zawodników z trenerami
        bind(vinicius, ancelotti);
        bind(mbappe, ancelotti);
        bind(haaland, guardiola);
        bind(rodri, guardiola);
        bind(salah, klopp);
        bind(vanDijk, klopp);
        bind(lewandowski, flick);
        bind(yamal, flick);

        // Tworzymy Drużyny (zamiast kin)
        Team realMadrid = new Team(1, "Real Madrid", "https://real-madrid-logo.png");
        Team manCity = new Team(2, "Manchester City", "https://man-city-logo.png");
        Team liverpool = new Team(3, "Liverpool FC", "https://liverpool-logo.png");
        Team barcelona = new Team(4, "FC Barcelona", "https://barcelona-logo.png");

        // Wiązanie drużyn z zawodnikami (Relacja wiele-do-wielu)
        bind(realMadrid, vinicius);
        bind(realMadrid, mbappe);
        bind(manCity, haaland);
        bind(manCity, rodri);
        bind(liverpool, salah);
        bind(liverpool, vanDijk);
        bind(barcelona, lewandowski);
        bind(barcelona, yamal);

        // Przykład historyczny/wielu drużyn: Lewy w reprezentacji (gdybyśmy mieli taki Team)
        // bind(polandNationalTeam, lewandowski);

        // Dodawanie do list statycznych
        players.add(vinicius);
        players.add(mbappe);
        players.add(haaland);
        players.add(rodri);
        players.add(salah);
        players.add(vanDijk);
        players.add(lewandowski);
        players.add(yamal);

        coaches.add(ancelotti);
        coaches.add(guardiola);
        coaches.add(klopp);
        coaches.add(flick);

        teams.add(realMadrid);
        teams.add(manCity);
        teams.add(liverpool);
        teams.add(barcelona);
    }

    // Pomocnicza metoda dla relacji Team <-> Player
    private static void bind(Team t, Player p) {
        t.addPlayer(p); // Zmienione z addMovie
        p.addTeam(t);   // Zmienione z addCinema
    }

    // Pomocnicza metoda dla relacji Player <-> Coach
    private static void bind(Player p, Coach c) {
        c.addPlayer(p); // Zmienione z addMovie
        p.setCoach(c);
    }
}