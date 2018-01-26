package com.mwsi.cepik.border.guards.appuser;

import com.mwsi.cepik.exception.DuplicatedUserException;
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
    public User add(UserForm userForm) {
        if (isDuplicated(userForm)) {
            throw new DuplicatedUserException(userForm.getEmail());
        }
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(encodePassword(userForm.getPassword()));
        return userRepository.save(user);
    }

    private boolean isDuplicated(UserForm userForm) {
        int count = userRepository.countByEmail(userForm.getEmail());
        return count != 0;
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

    User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    void update(UserForm userForm, Integer id) {
        User dbUser = findById(id);
        dbUser.setEmail(userForm.getEmail());
        dbUser.setName(userForm.getName());
        dbUser.setPassword(encodePassword(userForm.getPassword()));
        userRepository.save(dbUser);
    }

    @Transactional
    void delete(Integer id) {
        userRepository.delete(id);
    }

    private String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

}
