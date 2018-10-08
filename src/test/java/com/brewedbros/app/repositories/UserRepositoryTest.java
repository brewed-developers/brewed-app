package com.brewedbros.app.repositories;

import com.brewedbros.app.entities.User;
import com.brewedbros.app.entities.UserRole;
import com.brewedbros.app.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void testStoreUser() {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);
        User user = repository.save(User.builder().id(UUID.randomUUID().toString()).email("alex.foley@beverly-hills.com").password("my-secret-pwd").roles(roles).build());
        assertThat(user).isNotNull();
        assertThat(repository.count()).isGreaterThanOrEqualTo(1L);
    }

    @Test
    public void testFindByEmail() {
        User user = Users.newRandomOfficer();
        repository.save(user);
        Optional<User> optional = repository.findByEmailIgnoreCase(user.getEmail());
        assertThat(optional).isNotEmpty()
                .contains(user);
    }

    @Test
    public void testFindByEmailIgnoringCase() {
        User user = Users.newRandomOfficer();
        repository.save(user);
        Optional<User> optional = repository.findByEmailIgnoreCase(user.getEmail()
                .toUpperCase
                        (Locale.US));
        assertThat(optional).isNotEmpty()
                .contains(user);
    }

    @Test
    public void testFindByEmail_unknownEmail() {
        User user = Users.newRandomOfficer();
        repository.save(user);
        Optional<User> optional = repository.findByEmailIgnoreCase("will.not@find.me");
        assertThat(optional).isEmpty();
    }
}
