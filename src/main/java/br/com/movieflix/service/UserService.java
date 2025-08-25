package br.com.movieflix.service;

import br.com.movieflix.entity.User;
import br.com.movieflix.repositoiry.UserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRespository userRespository;
    private final PasswordEncoder passwordEncoder;

    public User save(User user){
        user.getPassword();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRespository.save(user);

    }
}
