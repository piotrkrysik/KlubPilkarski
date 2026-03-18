package club.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    @Column(name = "logo")
    private String logo;
    @ManyToMany(mappedBy = "teams")
    @JsonIgnore
    private List<Player> players = new ArrayList<>();

    public Team(int id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public Team() {
    }

    public void addPlayer(Player p) {
        if (p != null && !this.players.contains(p)) {
            this.players.add(p);
            if (!p.getTeams().contains(this)) {
                p.addTeam(this);
            }
        }
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getLogo() { return logo; }

    @JsonIgnore // KLUCZOWE: Zapobiega pętli Team -> Player -> Team
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}