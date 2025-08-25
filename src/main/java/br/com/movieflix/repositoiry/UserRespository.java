package br.com.movieflix.repositoiry;

import br.com.movieflix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User, Long> {

    Optional<UserDetails>findUserByEmail(String username);
}
