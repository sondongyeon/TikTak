package project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project.domain.VideoAdvertisement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VideoAdvertisementRepository extends JpaRepository<VideoAdvertisement, Long> {
    Optional<List<VideoAdvertisement>> findAllByVideoIdAndAdTimestampBetween(int videoId, LocalDateTime from, LocalDateTime to);
}
