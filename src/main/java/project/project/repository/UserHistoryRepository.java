package project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project.domain.UserHistory;

import java.util.Optional;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
    Optional<UserHistory> findByUserId(int userId);
    Optional<UserHistory> findByUserIdAndVideoId(int userId, int videoId);
}
