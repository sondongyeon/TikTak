package project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project.domain.PlayHistory;

public interface PlayHistoryRepository extends JpaRepository<PlayHistory, Long> {
}
