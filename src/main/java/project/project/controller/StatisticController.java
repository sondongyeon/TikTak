package project.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project.project.domain.Statistics;
import project.project.dto.StatsDTO;
import project.project.dto.TopFiveVideoDTO;
import project.project.dto.TopFiveVideoInterface;
import project.project.service.PlayHistoryService;
import project.project.service.StatisticsService;
import project.project.service.VideoAdvertisementService;
import project.project.service.VideoService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class StatisticController {
    private final VideoService videoService;
    private final PlayHistoryService playHistoryService;
    private final VideoAdvertisementService videoAdvertisementService;
    private final StatisticsService statisticsService;

    @PostMapping("/api/statistics")
    public ResponseEntity<List<Statistics>> createAllStatistics() {
        // 모든 비디오 id list로 가져오기 -> 반복문 돌면서
        // 일일 조회수
        // select count (*) from
        // play history 에서 video_id & 날짜로 묶은 다음에
        // last_watch_time 합치면 일일 영상 재생 시간
        // 여기서 count 하면 일일 조회수

        // 일일 광고 조회수
        // video_ad 에서 video_id & 날짜로 묶고
        // count

        // 위에 애들 모아서 amount 만들기
        List<Statistics> allStatistics = statisticsService.createStatistics();
        return ResponseEntity.ok().body(allStatistics);
    }

    @GetMapping("/api/stats/{id}")
    public ResponseEntity<List<StatsDTO>> getStatistics(@PathVariable int id) {
        List<Statistics> stats = statisticsService.findByVideoId(id);
        List<StatsDTO> response = new ArrayList<>();
        for (Statistics stat : stats) {
            response.add(statisticsService.createStatsInfo(stat));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/api/daily/views")
    public ResponseEntity<List<TopFiveVideoDTO>> getDailyTopFiveViews() {
        // 1. statistics에서 오늘 날짜 기준만 고르고, daily view 기준 top5 ..
        List<TopFiveVideoDTO> dailyTopViews = statisticsService.findDailyTop5Views();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dailyTopViews);
    }

    @GetMapping("/api/daily/playtime")
    public ResponseEntity<List<TopFiveVideoDTO>> getDailyTopFivePlaytime() {
        List<TopFiveVideoDTO> dailyTopPlaytime = statisticsService.findDailyTop5Playtime();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dailyTopPlaytime);
    }

    @GetMapping("/api/weekly/views")
    public ResponseEntity<List<TopFiveVideoInterface>> getWeeklyTopFiveViews() {
        List<TopFiveVideoInterface> weeklyTopViews = statisticsService.findWeeklyTop5Views();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(weeklyTopViews);
    }

    @GetMapping("/api/weekly/playtime")
    public ResponseEntity<List<TopFiveVideoInterface>> getWeeklyTopFivePlaytime() {
        List<TopFiveVideoInterface> weeklyTopPlaytime = statisticsService.findWeeklyTop5Playtime();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(weeklyTopPlaytime);
    }
    @GetMapping("/api/monthly/views")
    public ResponseEntity<List<TopFiveVideoInterface>> getMonthlyTopFiveViews() {
        List<TopFiveVideoInterface> monthlyTopViews = statisticsService.findMonthlyTop5Views();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monthlyTopViews);
    }

    @GetMapping("/api/monthly/playtime")
    public ResponseEntity<List<TopFiveVideoInterface>> getMonthlyTopFivePlaytime() {
        List<TopFiveVideoInterface> monthlyTopPlaytime = statisticsService.findMonthlyTop5Playtime();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monthlyTopPlaytime);
    }
}
