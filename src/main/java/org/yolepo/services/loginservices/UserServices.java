package org.yolepo.services.loginservices;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.yolepo.models.Role;
import org.yolepo.models.User;

import java.util.List;

/**
 * Created by mjali on 24/10/2016.
 */
public interface UserServices extends UserDetailsService {

    User addUser(User user);

    User getUser(Long userId);

    User getUser(String username);

    void updateUser(User user);

    void deleteUser(Long userId);

    List<User> getUsers();

    void assignRoleToUser(Role role, User user);
}
