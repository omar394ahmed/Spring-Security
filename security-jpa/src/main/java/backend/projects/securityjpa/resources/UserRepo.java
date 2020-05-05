package backend.projects.securityjpa.resources;

import backend.projects.securityjpa.Models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User , Integer> {

    public Optional<User> findByName(String name);
}
