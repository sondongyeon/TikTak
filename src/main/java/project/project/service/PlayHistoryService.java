package project.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.project.domain.PlayHistory;
import project.project.dto.AddPlayHistoryRequest;
import project.project.repository.PlayHistoryRepository;

@RequiredArgsConstructor
@Service
public class PlayHistoryService {
    private final PlayHistoryRepository playHistoryRepository;

    public PlayHistory save(AddPlayHistoryRequest request) {
        return playHistoryRepository.save(request.toEntity());
    }
}
