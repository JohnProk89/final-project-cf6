package gr.aueb.cf.finalprojectcf6.service;

import gr.aueb.cf.finalprojectcf6.dto.BoardGameInsertDTO;
import gr.aueb.cf.finalprojectcf6.model.BoardGame;
import gr.aueb.cf.finalprojectcf6.repository.BoardGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardGameService {

    private final BoardGameRepository boardGameRepository;

    public BoardGameInsertDTO addBoardGame(BoardGameInsertDTO boardGameInsertDTO) {
        BoardGame boardGame = mapBoardGameInsertDTOToBoardGame(boardGameInsertDTO);
        boardGameRepository.save(boardGame);
        return boardGameInsertDTO;
    }

    public BoardGame mapBoardGameInsertDTOToBoardGame(BoardGameInsertDTO boardGameInsertDTO) {
        BoardGame boardGame = new BoardGame();
        boardGame.setName(boardGameInsertDTO.getName());
        boardGame.setDescription(boardGameInsertDTO.getDescription());
        return boardGame;
    }
}
