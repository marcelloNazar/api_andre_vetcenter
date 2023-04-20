package vet.center.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vet.center.api.domain.user.DadosUser;
import vet.center.api.domain.user.UserJPA;
import vet.center.api.infra.security.DadosToken;
import vet.center.api.infra.security.TokenServiceApi;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager maneger;

    @Autowired
    private TokenServiceApi tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosUser dados) {
        var authToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        var auth = maneger.authenticate(authToken);

        var token = tokenService.gerarToken((UserJPA) auth.getPrincipal());

        return ResponseEntity.ok(new DadosToken(token));
    }


}
