package com.farmacia10.security;

import com.farmacia10.models.Usuario;
import com.farmacia10.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user =usuarioRepository.findByUsuario(username);
        user.orElseThrow(()->new UsernameNotFoundException(username+" not found" ));
        return user.map(UserDetailsImpl:: new).get();
    }
}
