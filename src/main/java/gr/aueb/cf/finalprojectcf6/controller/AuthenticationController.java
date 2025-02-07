package gr.aueb.cf.finalprojectcf6.controller;

import gr.aueb.cf.finalprojectcf6.dto.UserDTO;
import gr.aueb.cf.finalprojectcf6.model.User;
import gr.aueb.cf.finalprojectcf6.responses.LoginResponse;
import gr.aueb.cf.finalprojectcf6.service.AuthenticationService;
import gr.aueb.cf.finalprojectcf6.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/auth")
@Controller
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/signup")
    public String signupView(Model model) {
        System.out.println("Hi");
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView signup(@ModelAttribute("user") UserDTO userdto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/auth/signup", true);
        User signedUpUser = authenticationService.signup(userdto);
        redirectAttributes.addFlashAttribute("signedUpUser", signedUpUser);
        redirectAttributes.addFlashAttribute("signUpUserSuccess", true);
        return redirectView;
    }

    @PostMapping("/postman/signup")
    public ResponseEntity<User> register(@RequestBody UserDTO UserDto) {
        User registeredUser = authenticationService.signup(UserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody UserDTO UserDto) {
        User authenticatedUser = authenticationService.authenticate(UserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}