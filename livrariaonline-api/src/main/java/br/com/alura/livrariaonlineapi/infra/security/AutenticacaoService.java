package br.com.alura.livrariaonlineapi.infra.security;

import br.com.alura.livrariaonlineapi.dto.LoginDTO;
import br.com.alura.livrariaonlineapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository
                .findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    public String autenticar(LoginDTO loginDTO){

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                loginDTO.getLogin(),
                loginDTO.getSenha()
        );

        authentication = authenticationManager.authenticate(authentication);

        return tokenService.gerarToken(authentication);
    }



}
