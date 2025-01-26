package gr.aueb.cf.finalprojectcf6.controller;

import gr.aueb.cf.finalprojectcf6.dto.GameFavorDTO;
import gr.aueb.cf.finalprojectcf6.dto.UserDTO;
import gr.aueb.cf.finalprojectcf6.model.User;
import gr.aueb.cf.finalprojectcf6.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        System.out.println("Registering user: " + userDTO);
        UserDTO savedUser = userService.registerUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User presentedUser = userService.findById(id);
        return ResponseEntity.ok(presentedUser);
    }

    @GetMapping("/get/all")
    public ResponseEntity<Set<User>> getAllUsers() {
        Set<User> users = userService.showUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO) {
        System.out.println("Logging user: " + userDTO);
        String greeting = "Hello " + userService.loginUser(userDTO).getUsername() + "!";
        return ResponseEntity.ok(greeting);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        System.out.println("Updating user: " + user);
        userService.updateUser(user);
        return ResponseEntity.ok("User updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        System.out.println("Deleting user: " + id);
        String username = userService.deleteUser(id);
        return ResponseEntity.ok("User deleted: " + username);
    }

    @PostMapping("/favorgame")
    public ResponseEntity<String> addFavouriteGame(@RequestBody GameFavorDTO gameFavorDTO) {
        System.out.println("Adding favourite game: " + gameFavorDTO + " to a user, but which one?");
        userService.favorGame(gameFavorDTO);
        return ResponseEntity.ok("ok");
    }
}
