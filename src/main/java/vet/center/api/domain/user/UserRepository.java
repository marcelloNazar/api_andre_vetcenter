package vet.center.api.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserJPA, Long> {

    UserDetails findByLogin(String login);
}
