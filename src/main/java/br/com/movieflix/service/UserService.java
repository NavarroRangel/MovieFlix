package br.com.movieflix.service;

import br.com.movieflix.entity.User;
import br.com.movieflix.repositoiry.UserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRespository userRespository;

    public User save(User user){
        return userRespository.save(user);

    }
}
