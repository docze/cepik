package com.mwsi.cepik.border.guards.appuser;

import com.mwsi.cepik.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User add(User u) {
        u.setPassword(encodePassword(u.getPassword()));
        return userRepository.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                Collections.emptyList()
        );
    }

    User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    void update(User user, Integer id) {
        User dbUser = userRepository.getOne(id);
        dbUser.setEmail(user.getEmail());
        dbUser.setName(user.getName());
        dbUser.setPassword(user.getPassword());
    }

    @Transactional
    void delete(Integer id) {
        userRepository.delete(id);
    }

    private String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

}
