package project.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import project.project.domain.Video;
import project.project.dto.VideoListViewResponse;
import project.project.dto.VideoViewResponse;
import project.project.service.VideoService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class VideoViewController {
    private final VideoService videoService;
    @GetMapping("/videos")
    public String getVideos(Model model) {
        List<VideoListViewResponse> videos = videoService.findAll().stream()
                .map(VideoListViewResponse::new)
                .toList();

        model.addAttribute("video", videos);

        return "videoList";
    }

    @GetMapping("/videos/{id}")
    public String getVideo(@PathVariable Long id, Model model) {
        Video video = videoService.findById(id);
        model.addAttribute("video", new VideoViewResponse(video));
        return "video";
    }

    @GetMapping("/new-video")
    public String newVideo(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("video", new VideoViewResponse());
        } else {
            Video video = videoService.findById(id);
            model.addAttribute("video", new VideoViewResponse(video));
        }

        return "newVideo";
    }
}
