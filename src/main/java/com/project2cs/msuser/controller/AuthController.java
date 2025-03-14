package com.project2cs.msuser.controller;

import com.project2cs.msuser.model.Utilisateur;
import com.project2cs.msuser.repository.UtilisateurRepository;
import com.project2cs.msuser.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtService jwtService;
    private final UtilisateurRepository utilisateurRepository;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthController(JwtService jwtService, UtilisateurRepository utilisateurRepository, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.utilisateurRepository = utilisateurRepository;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String motDePasse) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findByEmail(email);
        if (utilisateurOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Email ou mot de passe incorrect");
        }

        Utilisateur utilisateur = utilisateurOpt.get();

        if (!passwordEncoder.matches(motDePasse, utilisateur.getMotDePasse())) {
            return ResponseEntity.status(401).body("Email ou mot de passe incorrect");
        }

        String token = jwtService.generateToken(email);
        return ResponseEntity.ok(token);
    }
}
