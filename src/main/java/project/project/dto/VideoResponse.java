package project.project.dto;

import project.project.domain.Video;

import java.time.LocalDateTime;

public class VideoResponse {
    private final long videoId;
    private final String title;
    private final int length;
    private final LocalDateTime uploadDate;
    private final int memberId;
    private final int totalPlaytime;
    private final int videoViews;

    public VideoResponse(Video video) {
        this.videoId = video.getVideoId();
        this.title = video.getTitle();
        this.length = video.getLength();
        this.uploadDate = video.getUploadDate();
        this.memberId = video.getMemberId();
        this.totalPlaytime = video.getTotalPlaytime();
        this.videoViews = video.getVideoViews();
    }
}
