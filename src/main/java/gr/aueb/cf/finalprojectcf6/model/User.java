package gr.aueb.cf.finalprojectcf6.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    private String password;

    @ManyToMany
    @JoinTable(name = "favouriteGames",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "boardGameId"))
    Set<BoardGame> favouriteGames = new HashSet<>();
}
