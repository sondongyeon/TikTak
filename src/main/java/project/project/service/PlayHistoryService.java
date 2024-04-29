package project.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.project.domain.PlayHistory;
import project.project.dto.PlayHistoryDTO;
import project.project.repository.PlayHistoryRepository;

@RequiredArgsConstructor
@Service
public class PlayHistoryService {
    private final PlayHistoryRepository playHistoryRepository;

    public PlayHistory save(PlayHistoryDTO request) {
        return playHistoryRepository.save(PlayHistory.builder()
                .videoId(request.getVideoId())
                .build());
    }
}
