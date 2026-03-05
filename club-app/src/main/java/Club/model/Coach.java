package Club.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private int id;
    private String firstName;
    private String lastName;

    // Relacja 1 do wielu: jeden trener prowadzi wielu zawodników
    private List<Player> players = new ArrayList<>();

    public Coach(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Coach() {
    }

    // Pomocnicza metoda do pobierania pełnego imienia i nazwiska (używaliśmy jej w Player.toString)
    public String getName() {
        return firstName + " " + lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player p) {
        this.players.add(p);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}