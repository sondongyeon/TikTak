package project.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.project.domain.Video;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VideoDTO {
    private String title;
    private int length;
    private int memberId;
    private int adId;

    public Video toEntity() {
        return Video.builder()
                .title(title)
                .length(length)
                .memberId(memberId)
                .adId(adId)
                .build();
    }
}
