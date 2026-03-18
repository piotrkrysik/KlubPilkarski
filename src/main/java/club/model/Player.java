package club.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @Column(name = "photoUrl")
    private String photoUrl;
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;
    @Column(name = "marketValue")
    private float marketValue;

    @ManyToMany
    @JoinTable(
        name = "player_team",
        joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id")
    )

    private List<Team> teams = new ArrayList<>();

    public Player(int id, String name, String photoUrl, Coach coach, float marketValue) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.coach = coach;
        this.marketValue = marketValue;
    }

    public Player() {
    }

    public void addTeam(Team team) {
        if (team != null && !this.teams.contains(team)) {
            this.teams.add(team);
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }

    public Coach getCoach() { return coach; }
    public void setCoach(Coach coach) { this.coach = coach; }

    public float getMarketValue() { return marketValue; }
    public void setMarketValue(float marketValue) { this.marketValue = marketValue; }

    @JsonIgnore
    public List<Team> getTeams() { return teams; }
    public void setTeams(List<Team> teams) { this.teams = teams; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id &&
                Float.compare(player.marketValue, marketValue) == 0 &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, marketValue);
    }

    @Override
    public String toString() {
        String coachName = (coach != null) ? coach.getName() : "brak";
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coach=" + coachName +
                ", marketValue=" + marketValue +
                '}';
    }
}