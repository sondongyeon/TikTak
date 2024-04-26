package project.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.project.domain.Video;
import project.project.dto.UpdateVideoRequest;
import project.project.repository.VideoRepository;
import project.project.dto.AddVideoRequest;
import java.util.List;


@RequiredArgsConstructor
@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public Video save(AddVideoRequest request) {
        return videoRepository.save(request.toEntity());
    }

    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    public Video findById(long id) {
        return videoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        videoRepository.deleteById(id);
    }

    @Transactional
    public Video update(long id, UpdateVideoRequest request) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        video.update(request.getTitle(), request.getLength());
        return video;
    }
}
