package gr.aueb.cf.finalprojectcf6.controller;

import gr.aueb.cf.finalprojectcf6.dto.BoardGameInsertDTO;
import gr.aueb.cf.finalprojectcf6.repository.BoardGameRepository;
import gr.aueb.cf.finalprojectcf6.service.BoardGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boardgame")
@RequiredArgsConstructor
public class BoardGameController {

    private final BoardGameRepository boardGameRepository;
    private final BoardGameService boardGameService;

    @PostMapping("/register")
    public ResponseEntity<BoardGameInsertDTO> addBoardGame(@RequestBody BoardGameInsertDTO boardGameInsertDTO) {
        System.out.println("Saving board game: " + boardGameInsertDTO);
        BoardGameInsertDTO boardGame = boardGameService.addBoardGame(boardGameInsertDTO);
        return ResponseEntity.ok(boardGame);
    }
}
