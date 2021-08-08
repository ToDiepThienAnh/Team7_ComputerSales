package cybersoft.backend.finalproject.ecommerce.security.service;

import cybersoft.backend.finalproject.ecommerce.user.model.User;
import cybersoft.backend.finalproject.ecommerce.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty())
            throw new UsernameNotFoundException("Username is invalid");
        Set<GrantedAuthority> authorities = new HashSet<>();
        String role = String.valueOf(user.get().getRole());
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        authorities.add(authority);
        return new UserDetailsImpl(user.get().getUsername(), user.get().getPassword(), authorities);
    }
}
