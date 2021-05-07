package io.org.alefwhite.services.impl;

import io.org.alefwhite.domains.entity.Empresa;
import io.org.alefwhite.domains.entity.Usuario;
import io.org.alefwhite.domains.repository.EmpresaRepository;
import io.org.alefwhite.domains.repository.UsuarioRepository;
import io.org.alefwhite.rest.dto.request.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Transactional
    public Usuario salvar(UsuarioDTO usuarioDTO) {
        Optional<Empresa> empresa = empresaRepository.findById(usuarioDTO.getEmpresa_id());
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario.setEmpresa(empresa.get());


        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        String[] roles = usuario.getAdmin() ? new String[] {"ADMIN", "USER"}
                            : new String[] {"USER"} ;

        return User
                .builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(roles)
                .build();
    }
}
