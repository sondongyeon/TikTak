package project.project.dto;

import project.project.domain.Video;

import java.time.LocalDateTime;

public class VideoResponse {
    private final String title;
    private final int length;
    private final LocalDateTime uploadDate;

    public VideoResponse(Video video) {
        this.title = video.getTitle();
        this.length = video.getLength();
        this.uploadDate = video.getUploadDate();
    }
}
