package com.mwsi.cepik.configuration;

import com.mwsi.cepik.border.guards.appuser.User;
import com.mwsi.cepik.border.guards.appuser.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitBorderGuardsDatabase {

    private final UserRepository userRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void initDb() {
        //users
        User testUser = new User("test", "test@test.pl", "test");
        userRepository.save(testUser);
    }
}
