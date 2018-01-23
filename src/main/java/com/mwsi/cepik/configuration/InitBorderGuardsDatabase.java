package com.mwsi.cepik.configuration;

import com.mwsi.cepik.border.guards.appuser.User;
import com.mwsi.cepik.border.guards.appuser.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitBorderGuardsDatabase {

    private final UserService userService;

    @EventListener(ContextRefreshedEvent.class)
    public void initDb() {
        //users
        User testUser = new User("test", "test@test.pl", "test");
        userService.add(testUser);
    }
}
