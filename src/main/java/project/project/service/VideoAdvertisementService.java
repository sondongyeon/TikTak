package project.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.project.domain.VideoAdvertisement;
import project.project.repository.AdvertisementRepository;
import project.project.repository.VideoAdvertisementRepository;
import project.project.repository.VideoRepository;
import project.project.util.RandomNumberGenerator;

@RequiredArgsConstructor
@Service
public class VideoAdvertisementService {
    private final VideoAdvertisementRepository videoAdvertisementRepository;
    private final AdvertisementRepository advertisementRepository;
    private final VideoRepository videoRepository;

    @Transactional
    public void checkVideoAdvertisement(int videoId, int playtime) {
        try {
            videoRepository.findById((long) videoId)
                    .orElseThrow(() -> new IllegalArgumentException("not found: " + videoId));
            RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
            int count = playtime / 300;
            for (int i = 0; i < count; i++) {
                int maxSize = advertisementRepository.countAllBy();
                videoAdvertisementRepository.save(VideoAdvertisement.builder()
                        .videoId(videoId)
                        .adId(randomNumberGenerator.randomNumberGenerator(maxSize))
                        .build());
            }
        } catch (IllegalArgumentException e) {
            return;
        }

    }
}
