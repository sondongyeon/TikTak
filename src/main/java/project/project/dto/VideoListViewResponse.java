package project.project.dto;

import lombok.Getter;
import project.project.domain.Video;

@Getter
public class VideoListViewResponse {
    private final Long id;
    private final String title;
    private final int length;
    private final int memberId;

    public VideoListViewResponse(Video video) {
        this.id = video.getVideoId();
        this.title = video.getTitle();
        this.length = video.getLength();
        this.memberId = video.getMemberId();
    }
}
