package project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project.domain.PlayHistory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PlayHistoryRepository extends JpaRepository<PlayHistory, Integer> {
    Optional<PlayHistory> findByUserId(int userId);
    Optional<PlayHistory> findByUserIdAndVideoId(int userId, int videoId);
    Optional<PlayHistory> findFirstByUserIdAndVideoIdOrderByPlayDateDesc(int userId, int videoId);
    Optional<List<PlayHistory>> findAllByVideoIdAndPlayDateBetween(int videoId, LocalDateTime from, LocalDateTime to);
}
