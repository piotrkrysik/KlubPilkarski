package club.repository.mem;

import club.model.Team;
import club.model.Coach;
import club.model.Player;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<Team> teams = new ArrayList<>();
    static List<Coach> coaches = new ArrayList<>();
    static List<Player> players = new ArrayList<>();

    static {
        Coach ancelotti = new Coach(1, "Carlo", "Ancelotti");
        Coach guardiola = new Coach(2, "Pep", "Guardiola");
        Coach klopp = new Coach(3, "Jurgen", "Klopp");
        Coach flick = new Coach(4, "Hansi", "Flick");

        Player vinicius = new Player(1, "Vinicius Jr", "https://img.a.transfermarkt.technology/portrait/big/371998-1761575144.jpg?lm=1", ancelotti, (float) 180.5);
        Player mbappe = new Player(2, "Kylian Mbappe", "https://img.a.transfermarkt.technology/portrait/big/342229-1682683695.jpg?lm=1", ancelotti, (float) 190.0);

        Player haaland = new Player(3, "Erling Haaland", "https://img.a.transfermarkt.technology/portrait/big/418560-1709108116.png?lm=1", guardiola, (float) 200.0);
        Player rodri = new Player(4, "Rodri", "https://img.a.transfermarkt.technology/portrait/big/357565-1682587890.jpg?lm=1", guardiola, (float) 130.0);

        Player salah = new Player(5, "Mohamed Salah", "https://img.a.transfermarkt.technology/portrait/big/148455-1727337594.jpg?lm=1", klopp, (float) 65.0);
        Player vanDijk = new Player(6, "Virgil van Dijk", "https://img.a.transfermarkt.technology/portrait/big/139208-1702049837.jpg?lm=1", klopp, (float) 30.0);

        Player lewandowski = new Player(7, "Robert Lewandowski", "https://img.a.transfermarkt.technology/portrait/big/38253-1760445524.jpg?lm=1", flick, (float) 15.0);
        Player yamal = new Player(8, "Lamine Yamal", "https://img.a.transfermarkt.technology/portrait/big/937958-1746563945.jpg?lm=1", flick, (float) 120.0);

        bind(vinicius, ancelotti);
        bind(mbappe, ancelotti);
        bind(haaland, guardiola);
        bind(rodri, guardiola);
        bind(salah, klopp);
        bind(vanDijk, klopp);
        bind(lewandowski, flick);
        bind(yamal, flick);

        Team realMadrid = new Team(1, "Real Madrid", "https://tmssl.akamaized.net//images/wappen/head/418.png?lm=1729684474");
        Team manCity = new Team(2, "Manchester City", "https://tmssl.akamaized.net//images/wappen/head/281.png?lm=1467356331");
        Team liverpool = new Team(3, "Liverpool FC", "https://tmssl.akamaized.net//images/wappen/big/31.png?lm=1727873452");
        Team barcelona = new Team(4, "FC Barcelona", "https://tmssl.akamaized.net//images/wappen/head/131.png?lm=1406739548");

        // Wiązanie drużyn z zawodnikami (Relacja wiele-do-wielu)
        bind(realMadrid, vinicius);
        bind(realMadrid, mbappe);
        bind(manCity, haaland);
        bind(manCity, rodri);
        bind(liverpool, salah);
        bind(liverpool, vanDijk);
        bind(barcelona, lewandowski);
        bind(barcelona, yamal);

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