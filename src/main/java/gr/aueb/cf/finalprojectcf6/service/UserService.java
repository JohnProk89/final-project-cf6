package gr.aueb.cf.finalprojectcf6.service;

import gr.aueb.cf.finalprojectcf6.dto.BoardGameFavorDTO;
import gr.aueb.cf.finalprojectcf6.dto.UserInsertDTO;
import gr.aueb.cf.finalprojectcf6.model.BoardGame;
import gr.aueb.cf.finalprojectcf6.model.User;
import gr.aueb.cf.finalprojectcf6.repository.BoardGameRepository;
import gr.aueb.cf.finalprojectcf6.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BoardGameRepository boardGameRepository;

    public UserInsertDTO registerUser(UserInsertDTO userInsertDTO) {
            User user = mapUserInsertDTOToUser(userInsertDTO);
            userRepository.save(user);
            return userInsertDTO;
    }

    public String showUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return "user not found";
        }
        return optionalUser.get().getUsername();
    }

    public UserInsertDTO loginUser(UserInsertDTO userInsertDTO) {
        User user = mapUserInsertDTOToUser(userInsertDTO);
        userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return userInsertDTO;
    }

    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User deleteUser(User user) {
        userRepository.delete(user);
        return user;
    }

    public void favorGame(BoardGameFavorDTO boardGameFavorDTO) {
        Optional<User> userOptional = userRepository.findById(boardGameFavorDTO.getUserId());
        if (userOptional.isEmpty()) {
            return;
        }
        User user = userOptional.get();
        Optional<BoardGame> boardGameOptional = boardGameRepository.findById(boardGameFavorDTO.getGameId());
        if (boardGameOptional.isEmpty()) {
            return;
        }
        BoardGame boardGame = boardGameOptional.get();
        Set<BoardGame> favouriteGames = user.getFavouriteGames();
        favouriteGames.add(boardGame);
        user.setFavouriteGames(favouriteGames);
        userRepository.save(user);
    }

    public User mapUserInsertDTOToUser(UserInsertDTO userInsertDTO) {
        User user = new User();
        user.setUsername(userInsertDTO.getUsername());
        user.setPassword(userInsertDTO.getPassword());
        return user;
    }
}
