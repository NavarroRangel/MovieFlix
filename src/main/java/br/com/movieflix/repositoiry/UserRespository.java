package br.com.movieflix.repositoiry;

import br.com.movieflix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {
}
