package io.org.alefwhite.rest.controllers;

import io.org.alefwhite.domains.entity.Usuario;
import io.org.alefwhite.rest.dto.UsuarioDTO;
import io.org.alefwhite.services.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioController {
    // Utilizando RequiredArgConstructor - devemos criar uma variavel final para ele injetar automaticamente a service
    private final UsuarioServiceImpl usuarioService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody UsuarioDTO usuarioDTO) {
        String senhaCriptografada = passwordEncoder.encode(usuarioDTO.getSenha());
        usuarioDTO.setSenha(senhaCriptografada);

        return usuarioService.salvar(usuarioDTO);
    }
}
