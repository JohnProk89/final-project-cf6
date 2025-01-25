package gr.aueb.cf.finalprojectcf6.controller;

import gr.aueb.cf.finalprojectcf6.dto.BoardGameFavorDTO;
import gr.aueb.cf.finalprojectcf6.dto.UserInsertDTO;
import gr.aueb.cf.finalprojectcf6.model.User;
import gr.aueb.cf.finalprojectcf6.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserInsertDTO> registerUser(@RequestBody UserInsertDTO userInsertDTO) {
        System.out.println("Registering user: " + userInsertDTO);
        UserInsertDTO savedUser = userService.registerUser(userInsertDTO);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getUser(@PathVariable Long id) {
        String presentedUser = userService.showUser(id);
        return ResponseEntity.ok(presentedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserInsertDTO userInsertDTO) {
        System.out.println("Logging user: " + userInsertDTO);
        String greeting = "Hello " + userService.loginUser(userInsertDTO).getUsername() + "!";
        return ResponseEntity.ok(greeting);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        System.out.println("Updating user: " + user);
        userService.updateUser(user);
        return ResponseEntity.ok("User updated");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody User user) {
        System.out.println("Deleting user: " + user);
        userService.deleteUser(user);
        return ResponseEntity.ok("User deleted");
    }

    @PostMapping("/favorgame")
    public ResponseEntity<String> addFavouriteGame(@RequestBody BoardGameFavorDTO boardGameFavorDTO) {
        System.out.println("Adding favourite game: " + boardGameFavorDTO + " to a user, but which one?");
        userService.favorGame(boardGameFavorDTO);
        return ResponseEntity.ok("ok");
    }
}
