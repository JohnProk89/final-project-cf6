package gr.aueb.cf.finalprojectcf6.repository;

import gr.aueb.cf.finalprojectcf6.model.BoardGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardGameRepository extends JpaRepository<BoardGame, Long> {
}
