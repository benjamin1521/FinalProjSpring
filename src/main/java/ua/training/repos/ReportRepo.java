package ua.training.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.entities.Report;
import ua.training.entities.User;

import java.util.List;

public interface ReportRepo extends JpaRepository<Report, Long> {
    List<Report> findAllByClientId(User user);

    List<Report> findAllByInspectorId(User user);

}
