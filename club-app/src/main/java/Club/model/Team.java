package Club.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private int id;
    private String name;
    private String logo;
    private List<Player> players = new ArrayList<>();

    public Team(int id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public Team() {
    }

    public void addPlayer(Player p) {
        this.players.add(p);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }

    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}