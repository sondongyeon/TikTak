package project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.project.domain.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
