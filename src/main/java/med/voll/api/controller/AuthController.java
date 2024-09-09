package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.record.user.AuthData;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationManager authRepository;

    @PostMapping
    public ResponseEntity makeLogin (@RequestBody @Valid AuthData authData){
        UsernamePasswordAuthenticationToken token =new UsernamePasswordAuthenticationToken(authData.login(),authData.password());
        Authentication authentication = this.authRepository.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
