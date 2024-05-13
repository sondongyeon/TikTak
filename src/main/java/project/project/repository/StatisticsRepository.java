package project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import project.project.domain.Statistics;
import project.project.dto.TopFiveVideoInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
    Optional<List<Statistics>> findAllByVideoId(int id);

    List<Statistics> findDailyTop5Views(@Param("statsDate") LocalDate statsDate);

    List<Statistics> findDailyTop5Playtime(@Param("statsDate") LocalDate statsDate);

    List<TopFiveVideoInterface> findTop5ViewsBetween(@Param("froms") LocalDate froms, @Param("tos") LocalDate tos);

    List<TopFiveVideoInterface> findTop5PlaytimeBetween(@Param("froms") LocalDate froms, @Param("tos") LocalDate tos);
}
