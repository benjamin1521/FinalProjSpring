package ua.training.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.entities.Mod;
import ua.training.entities.Report;

import java.util.List;

public interface ModRepo extends JpaRepository<Mod, Long> {
    List<Mod> findAllByReportsId(Report report);

    void deleteAllByReportsId(Report report);
}
