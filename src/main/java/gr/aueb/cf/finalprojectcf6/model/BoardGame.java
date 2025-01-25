package gr.aueb.cf.finalprojectcf6.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "boardGames")
public class BoardGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardGameId;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "favouriteGames")
    Set<User> users = new HashSet<>();
}
