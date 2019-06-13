package ua.training.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.entities.Report;
import ua.training.entities.User;
import ua.training.entities.enums.Role;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    List<User> findByRole(Role role);

    List<User> findByRoleAndInspectorReportsNotContaining(Role role,Report report);

}
