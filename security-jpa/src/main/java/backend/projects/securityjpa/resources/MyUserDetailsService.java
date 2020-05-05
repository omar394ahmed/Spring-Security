package backend.projects.securityjpa.resources;

import backend.projects.securityjpa.Models.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import backend.projects.securityjpa.Models.User;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repository ;

    @Override
    public UserDetails loadUserByUsername(String Username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByName(Username);
        user.orElseThrow(() -> new UsernameNotFoundException("bad credintials no such UserName : " + Username));
        return user.map(MyUserDetails::new).get();
    }
}
