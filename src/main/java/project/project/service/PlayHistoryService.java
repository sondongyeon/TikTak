package project.project.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.project.domain.PlayHistory;
import project.project.dto.PlayHistoryDTO;
import project.project.repository.PlayHistoryRepository;

@RequiredArgsConstructor
@Service
public class PlayHistoryService {
    private final PlayHistoryRepository playHistoryRepository;

    public PlayHistory save(PlayHistoryDTO request, int length) {
        if (request.getPlayTime() >= length) {
            request.setPlayTime(0);
        }
        return playHistoryRepository.save(PlayHistory.builder()
                .videoId(request.getVideoId())
                .userId(request.getMemberId())
                .lastWatchTime(request.getPlayTime())
                .build());
    }

    @Transactional
    public PlayHistory updateLastWatchTime(PlayHistoryDTO request) {
        PlayHistory lastHistory = findFirstByUserIdAndVideoIdOrderByPlayDateDesc(request.getMemberId(), request.getVideoId());
        lastHistory.update(request.getPlayTime());
        return lastHistory;
    }

    public PlayHistory findAllVideoHistoryByUserId(long userId) {
        return playHistoryRepository.findById((int) userId)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + userId));
    }

    public PlayHistory findVideoHistoryByUserId(int userId, int videoId) {

        return playHistoryRepository.findByUserIdAndVideoId(userId, videoId)
                .orElseThrow(() -> new IllegalArgumentException("not found user: " + userId + " video: "+ videoId));
    }

    public PlayHistory findFirstByUserIdAndVideoIdOrderByPlayDateDesc(int userId, int videoId) {
        return playHistoryRepository.findFirstByUserIdAndVideoIdOrderByPlayDateDesc(userId, videoId)
                .orElseThrow(() -> new IllegalArgumentException("not found user: " + userId + " video: "+ videoId));
    }
}
